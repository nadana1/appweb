import re
from bs4 import BeautifulSoup
import requests
import re
import mysql.connector
conn=mysql.connector.connect(host="localhost",
                               user="root", password="password", 
                               database="pcd")
cur=conn.cursor()
query="""SELECT namec FROM history"""
cur.execute (query)
L1=cur.fetchall()
L2=[]
for i in L1:
    L2.append(i[0])
    

symbol=L2[len(L2)-1]  
url="https://www.ilboursa.com/marches/cotation_"+symbol

#for i in range (0 , len(url)):
#    if url[i]=='=':
#        symbol=url[i+1::]
r=requests.get(url)
#print (r.status_code)
soup=BeautifulSoup(r.text, 'html.parser')

#for tag in soup.find_all('span', {'class':re.compile("headline")}):
#    print(tag.text)
league_table=soup.find('table', class_='tableVar')
for team in league_table.find_all('tbody'):
   rows=team.find_all('tr') 
   for row in rows:
       period=row.find('td').text
       low=row.find_all('td')[1].text[:-1].replace(',','.')
       heigh=row.find_all('td')[2].text[:-1].replace(',','.')
       variation=row.find_all('td')[3].text[:-1].replace(',','.')
       cur.execute ("""INSERT INTO resume_history Values (%s,%s,%s,%s,%s)""",(symbol,period,low,heigh,variation)) 
       conn.commit()
       