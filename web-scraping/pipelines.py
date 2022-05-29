# Define your item pipelines here
# Don't forget to add your pipeline to the ITEM_PIPELINES setting
# See: https://docs.scrapy.org/en/latest/topics/item-pipeline.html


# useful for handling different item types with a single interface

from multiprocessing.dummy.connection import Connection
import mysql.connector
from itemadapter import ItemAdapter
from google import * 

class ProjectPipeline:
      def __init__(self):
            self.conn=mysql.connector.connect(host="localhost",
                               user="root", password="password", 
                               database="pcd")

            self.cur=self.conn.cursor()
             
      def process_item(self, item, spider):
        #self.store_db(item)
             self.cur.execute("""INSERT INTO siteconfirmed VALUES (%s,%s,%s,%s)""", (item['idsite'],'meta',item['namesite'],item['link']))
             self.conn.commit()
             return item
    
    
