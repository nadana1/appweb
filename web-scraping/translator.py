from googletrans import Translator
import mysql.connector

conn=mysql.connector.connect(host="localhost",
                               user="root", password="password", 
                               database="pcd")
cur=conn.cursor()
query="""SELECT * FROM synonym"""
cur.execute (query)
L1=cur.fetchall()

for i in L1:
    translater=Translator()
    out= translater.translate(i[2], dest="fr")
    cur.execute ("""INSERT INTO synonymFr Values (%s,%s,%s)""",(i[0],i[1],out.text)) 
    conn.commit()
    print(i[0],i[1],out.text)
    
    
