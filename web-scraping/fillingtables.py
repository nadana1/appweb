import csv
import mysql.connector
conn=mysql.connector.connect(host="localhost",
                               user="root", password="password", 
                               database="pcd")
cur=conn.cursor()
    
with open('devisevariation.csv', newline='') as csvfile:
 reader = csv.DictReader(csvfile)
 for row in reader:
        L=[]
        for i in row.values():
            L.append(i)
        date=L[0].replace('/','-')
        indice=date.index('-')
        month=date[:indice] 
        rest=date[indice+1:]
        indice2=rest.index('-')
        day=rest[:indice2]
        year=rest[indice2+1:]
        date=year+'-'+month+'-'+day
        cur.execute ("""INSERT into varfactors  Values (%s,%s,%s,%s)""",(date,float(L[1]),float(L[2]),float(L[3]))) 
        conn.commit()
        
        
        