import requests
import pymysql

try :
    dbConn = pymysql.connect(host='localhost', port= 3306, user='root', password='1234', db='ksh', charset='utf8')
except :
    print("DB connection error")
else :
    cursor = dbConn.cursor()

    # sql = "select * from member where userId = %s and userPwd = sha1(md5(%s))"
    # userId = "abc123"
    # userPwd = "111"
    # cursor.execute(sql, (userId, userPwd))

    # # fetchone() : 결과 row가 한 행일때
    # # fetchall() : 결과 row가 여러 행일때

    # result = cursor.fetchone()
    # print(result)

    sql = "select * from member"
    cursor.execute(sql)
    result = cursor.fetchall()
    for row in result :
        print(list(row))

    dbConn.close()