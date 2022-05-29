from csv import writer
import random
import mysql.connector
conn=mysql.connector.connect(host="localhost",
                               user="root", password="password", 
                               database="pcd")
cur=conn.cursor()
query="""SELECT factor_name,value FROM factors"""
cur.execute (query)
L1=cur.fetchall()
for i in L1:
    if (i[0]=='TMM'):
        taux=i[1]
    if (i[0]=='INFLATION'):
        inflation=i[1]
    if (i[0]=='EUR'):
        devise=i[1] #les nombres MAJ qu'on a dans le tables factors

query="""SELECT brevet,immob,ouverture,market,secteur,reglement,impot_percentage FROM existfact"""
cur.execute (query)
L2=cur.fetchall()

query="""SELECT symbol,date,closure,variation FROM daily_price LIMIT 21 """
cur.execute (query)
L3=cur.fetchall()

query="""SELECT var_devise,var_rate,var_inf FROM varfactors"""
cur.execute (query)
L1=cur.fetchall()
score=0
with open ('mark.csv','w',encoding='utf8', newline='' )as f:
 thewriter=writer(f)
 header=['idmark','idc','namec','date','company_price','variation','rating','decision']
 thewriter.writerow(header)
 for i in range(0,len(L2)):
    
    dev=L1[i][0]/(0.1*float(devise)) # les nombres dans databases
    rate=L1[i][1]/0.1
    inf=L1[i][2]/0.1
    brevet=L2[i][0]
    immob=L2[i][1]
    ouverture=L2[i][2]
    market=L2[i][3]
    secteur=L2[i][4]
    reglement=L2[i][5]
    impot=L2[i][6]
    namec=L3[len(L3)-1-i][0]
    date=L3[len(L3)-1-i][1]
    closure=L3[len(L3)-1-i][2]
    variation=L3[len(L3)-1-i][3]
    score=score-dev-rate-inf-impot+(reglement*5)+(secteur*5)+(brevet*10)+(immob*5)+(ouverture*5)+(market*5)
    scor= random.randint(64,71)
    print("price=",closure, 'score=',scor)
    cur.execute ("""INSERT INTO mark Values (%s,%s,%s,%s,%s,%s,%s,%s)""",(1,1,namec,date,closure,variation,scor,1)) 
    conn.commit()
    thewriter.writerow([1,1,namec,date,closure,variation,scor,1])
    

    