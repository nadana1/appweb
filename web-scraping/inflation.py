import re
from bs4 import BeautifulSoup
import requests
import re
import mysql.connector
conn=mysql.connector.connect(host="localhost",
                               user="root", password="password", 
                               database="pcd")
cur=conn.cursor()

url="http://www.ins.tn/"


r=requests.get(url)

soup=BeautifulSoup(r.text, 'html.parser')

rate=soup.find('div', class_='views-field views-field-field-valeur')
t=rate.text[:-1].replace(',','.')

factor =soup.find('div', class_='views-field views-field-field-titre-chiffre')
f=factor.text      
      
cur.execute ("""INSERT INTO factors Values (%s,%s)""",(f,t)) 
conn.commit()        
     
     
    