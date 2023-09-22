import requests
import pymysql

try :
    dbConn = pymysql.connect(host='localhost', port= 3306, user='root', password='1234', db='ksh', charset='utf8')
except :
    print("DB connection error")
else :
    cursor = dbConn.cursor()

    sql = "insert into pointpolicy values(%s, %s)"
    result = cursor.execute(sql, ('로그아웃', '-1'))
    print(result)
    dbConn.commit()
    dbConn.close()