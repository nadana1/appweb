import re
from bs4 import BeautifulSoup
import requests
import re
import mysql.connector
conn=mysql.connector.connect(host="localhost",
                               user="root", password="password", 
                               database="pcd")
cur=conn.cursor()

url="https://www.ilboursa.com/"
r=requests.get(url)
soup=BeautifulSoup(r.text, 'html.parser')
league_table=soup.find('table', class_='tblcom')
for row in league_table.find_all('tr'):
    date=row.find('td').text
    new=row.find_all('td')[1].text
    cur.execute ("""INSERT INTO news Values (%s,%s)""",(date, new)) 
    conn.commit() 
    
   
       