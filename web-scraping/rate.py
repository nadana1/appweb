import re
from bs4 import BeautifulSoup
import requests
import re
import mysql.connector
conn=mysql.connector.connect(host="localhost",
                               user="root", password="password", 
                               database="pcd")
cur=conn.cursor()

url="https://www.bct.gov.tn/bct/siteprod/index.jsp"


r=requests.get(url)

soup=BeautifulSoup(r.text, 'html.parser')

league_table=soup.find('div', class_='content')
nb=0
abr=['TM','TID','TMM','TRE']
i=0
for team in league_table:
    if (nb<8) :
        if (nb%2==0):
         nb=nb+1
        else:
            
            p=team.text.strip().index(':')
            word=team.text[:p]
            p=p+1
            value=team.text[p+1:][:4].replace(',','.')
            nb=nb+1
            cur.execute ("""INSERT INTO rate Values (%s,%s,%s)""",(abr[i],word,value)) 
            conn.commit()
            if (abr[i]=='TMM'):
                cur.execute ("""INSERT INTO factors Values (%s,%s)""",(abr[i],value)) 
                conn.commit()   
            i=i+1
            
            
     
     
    