import nltk
from flask import Flask, render_template, request
import json
from os import path
import mysql.connector

conn=mysql.connector.connect(host="localhost",
                               user="root", password="password", 
                               database="pcd")
cur=conn.cursor()

nltk.download('wordnet')
from nltk.corpus import wordnet
query="""SELECT word FROM keyword"""
cur.execute (query)
L1=cur.fetchall()
L2=[]
for i in L1:
  L2.append(i[0])

query="""SELECT COUNT(*) FROM synonym """
cur.execute (query)
nb=cur.fetchall()[0][0]
nb=nb+1
L3=[]
for word in L2:
    
    syn =wordnet.synsets(word) 
    synonyms = []
    for syn in wordnet.synsets(word): 
        for lemma in syn.lemmas():
            if (((lemma.name()in synonyms)==False) and len(synonyms)<5):
                   synonyms.append(lemma.name()) 
    for w in synonyms:
          L3.append((nb,L2.index(word)+1,w))
          nb=nb+1 
          

for item in L3:
       cur.execute ("""INSERT INTO synonym Values (%s,%s,%s)""",(item[0],item[1],item[2])) 
       conn.commit()
       L1=cur.fetchall()


