from selenium import webdriver
from bs4 import BeautifulSoup
from selenium.webdriver.chrome.service import Service as ChromeService
import mysql.connector
import re
import requests
conn=mysql.connector.connect(host="localhost",
                               user="root", password="password", 
                               database="pcd")
cur=conn.cursor()
#####
req =""" SELECT  link FROM siteconfirmed"""
cur.execute (req)
L1=cur.fetchall()
L3=[]
for i in L1:
  L3.append(i[0]) # L3 comporte les sites confirmés

#####
query="""SELECT idword,synonym FROM synonymFr """
cur.execute (query)
L1=cur.fetchall()
L2=[]
for i in L1:
  L2.append(i)
  
 # L2 comporte tous les (idword,synonym) 

dic_syn={}
for t in L2:
      # initialiser listes de synonymes vides pour chaque idword 
      dic_syn[t[0]]=[]
for t in L2:
      
      dic_syn[t[0]].append(t[1])
      # ajout des synonymes pour la liste correspondante selon idword

dic_freq={}
for t in L2:
      dic_freq[t[1]]=0 #initialisation de valeurs nulles au dic_freq
      
url="https://www.ilboursa.com/marches/actualites_bourse_tunis?t=c"
r=requests.get(url)
soup=BeautifulSoup(r.text, 'html.parser')
body=soup.find('body')
for t in L2:
    freq = body.text.lower().count(t[1]) # .lower() to account for count's case sensitive behaviour
    dic_freq[t[1]]=dic_freq[t[1]]+freq
url=" http://www.ins.tn/communique-de-presse"
r=requests.get(url)
soup=BeautifulSoup(r.text, 'html.parser')
body=soup.find('body')
for t in L2:
    freq = body.text.lower().count(t[1]) # .lower() to account for count's case sensitive behaviour
    dic_freq[t[1]]=dic_freq[t[1]]+freq


dic_word_freq={}
for i in dic_syn.keys():
      dic_word_freq[i]=0
      
for i in dic_syn.keys():
      for syn in dic_syn[i]:
            dic_word_freq[i]=dic_word_freq[i]+dic_freq[syn]
L5=[]
for i in dic_word_freq.keys(): 
      L5.append((i, dic_word_freq[i]))
      #print ((i, 'nb= ', dic_word_freq[i], dic_syn[i] ))
L6=[]



cur.execute ("""INSERT INTO nbfact Values (%s,%s,%s,%s,%s,%s,%s)""",('1',L5[0][1]+L5[1][1]+L5[18][1],L5[8][1],L5[5][1]+L5[17][1],L5[16][1]+L5[3][1]+L5[22][1],L5[12][1],L5[13][1])) 
conn.commit()
