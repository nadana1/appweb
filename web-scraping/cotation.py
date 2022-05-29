import re
from bs4 import BeautifulSoup
import requests
import re
import mysql.connector
from csv import writer
conn=mysql.connector.connect(host="localhost",
                               user="root", password="password", 
                               database="pcd")
cur=conn.cursor()

url="https://www.ilboursa.com/marches/aaz"

#for i in range (0 , len(url)):
#    if url[i]=='=':
#        symbol=url[i+1::]
r=requests.get(url)
#print (r.status_code)
soup=BeautifulSoup(r.text, 'html.parser')

#for tag in soup.find_all('span', {'class':re.compile("headline")}):
#    print(tag.text)
league_table=soup.find('table', class_='tablesorter tbl100_6 tbl1')
with open ('cotation.csv','w',encoding='utf8', newline='' )as f:
 thewriter=writer(f)
 header=['name','opening','heigh','low','volume','last','variation']
 thewriter.writerow(header)
 for team in league_table.find_all('tbody'):
   rows=team.find_all('tr') 
   for row in rows:
       name=row.find('td').text
       ouverture=row.find_all('td')[1].text[:-1].replace(',','.')
       low=row.find_all('td')[3].text[:-1].replace(',','.')
       heigh=row.find_all('td')[2].text[:-1].replace(',','.')
       volume=row.find_all('td')[5].text
       dernier=row.find_all('td')[6].text[:-1].replace(',','.')
       variation=row.find_all('td')[7].text[:-1].replace(',','.')
       cur.execute ("""INSERT INTO cotation Values (%s,%s,%s,%s,%s,%s,%s)""",(name,ouverture,heigh,low,volume, dernier,variation)) 
       conn.commit()
       thewriter.writerow([name,ouverture,heigh,low,volume, dernier,variation])