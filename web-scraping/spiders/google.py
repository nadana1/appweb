import scrapy
from scrapy.crawler import CrawlerProcess
from urllib.parse import urlencode
from urllib.parse import urlparse
import json
from datetime import datetime
import mysql.connector
conn=mysql.connector.connect(host="localhost",
                               user="root", password="password", 
                               database="pcd")
cur=conn.cursor()
API_KEY = '426ff9851ce64dd4861e0e1a5928caac'

def get_url(url):

    payload = {'api_key': API_KEY, 'url': url, 'autoparse': 'true', 'country_code': 'fr'}

    proxy_url = 'http://api.scraperapi.com/?' + urlencode(payload)

    return proxy_url

def create_google_url(query, site=''):

    google_dict = {'q': query, 'num':5, }

    if site:

        web = urlparse(site).netloc

        google_dict['as_sitesearch'] = web

        return 'http://www.google.com/search?' + urlencode(google_dict)

    return 'http://www.google.com/search?' + urlencode(google_dict)

class GoogleSpider(scrapy.Spider, object):
   
    
    name = 'google'

    allowed_domains = ['api.scraperapi.com']

    custom_settings = {'ROBOTSTXT_OBEY': False, 'LOG_LEVEL': 'INFO',

                       'CONCURRENT_REQUESTS_PER_DOMAIN': 10, 

                       'RETRY_TIMES': 5}

    def start_requests(self):

        queries = ['meta'] # à remplacer par input

        for query in queries:

            url = create_google_url(query)
            req= """select count(*) from siteconfirmed"""
            cur.execute (req)
            pos=cur.fetchall()[0][0]
            pos=pos+1
            yield scrapy.Request(get_url(url), callback=self.parse, meta={'pos': pos})

    def parse(self, response):
       
        di = json.loads(response.text)
        pos = response.meta['pos']
        dt = datetime.now().strftime('%Y-%m-%d %H:%M:%S')
        
        for result in di['organic_results']:

              title = result['title']
              link = result['link']
              item = { 'idsite': pos, 'namesite': title, 'link': link}
              pos += 1
              print (item['idsite'],item['namesite'],item['link'])
              yield item
              
        next_page = di['pagination']['nextPageUrl']
        if next_page:

            yield scrapy.Request(get_url(next_page), callback=self.parse, meta={'pos': pos})
            
       
    