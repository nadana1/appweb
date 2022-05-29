import re
from bs4 import BeautifulSoup
import requests
import re
from csv import writer
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
symbol='BIAT'
url="https://www.ilboursa.com/marches/historiques?s="+symbol


#for i in range (0 , len(url)):
#    if url[i]=='=':
#        symbol=url[i+1::]
r=requests.get(url)
#print (r.status_code)
soup=BeautifulSoup(r.text, 'html.parser')
league_table=soup.find('table', class_='tablenosort tbl100_6')
with open ('cours.csv','w',encoding='utf8', newline='' )as f:
 thewriter=writer(f)
 header=['symbol','date','closure','opening','variation']
 thewriter.writerow(header)
 for team in league_table.find_all('tbody'):
   rows=team.find_all('tr') 
   nb=1
   for row in rows:
    
       date=row.find('td').text.replace('/','-')
       year=date[-4:] 
       month=date[3:5]
       day=date[:2] 
       date=year+'-'+month+'-'+day
       closure=row.find_all('td')[1].text[:-1].replace(',','.')
       opening=row.find_all('td')[4].text[:-1].replace(',','.')
       variation=row.find_all('td')[7].text[:-1].replace(',','.')
       cur.execute ("""INSERT INTO daily_price Values (%s,%s,%s,%s,%s)""",(symbol,date,float(closure),float(opening),float(variation)))
       conn.commit() 
       nb=nb+1
       thewriter.writerow([symbol,date,closure,opening,variation])
 

 
   