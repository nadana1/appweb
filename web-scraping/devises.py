import re
from bs4 import BeautifulSoup
import requests
import re
import mysql.connector
conn=mysql.connector.connect(host="localhost",
                               user="root", password="password", 
                               database="pcd")
cur=conn.cursor()

url="https://www.bct.gov.tn/bct/siteprod/cours.jsp"


r=requests.get(url)

soup=BeautifulSoup(r.text, 'html.parser')
acr=['CAD', 'USD', 'GBP','JPY','MAD','EUR','LYD']
league_table=soup.find('div', class_='bct-header-fixed')
for team in league_table.find_all('tbody'):
   rows=team.find_all('tr') 
   for row in rows:
       money=row.find('td').text.strip()
       acronym=row.find_all('td')[1].text
       unit=row.find_all('td')[2].text
       value=float (row.find_all('td')[3].text.replace(',','.'))
       if acronym in acr:
          
          cur.execute ("""INSERT INTO devises Values (%s,%s,%s,%s)""",(money, acronym,unit, value)) 
          conn.commit()
          if (acronym=='EUR'):
              cur.execute ("""INSERT INTO factors Values (%s,%s)""",(acronym,value)) 
              conn.commit() 
       