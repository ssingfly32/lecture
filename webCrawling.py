# 웹 크롤링 : 웹 문서를 긁어와 데이터를 저장하기 위한 프로그램 류
# 라이선스

import requests
from bs4 import BeautifulSoup
import pymysql

# 함수는 import 밑에
def insertProduct(productNo, productName, thumbNailImg, description, price, detailPage) :
    print(productNo, productName, thumbNailImg, description, price, detailPage)

baseUrl = "https://lemite.com"
targetUrl = "https://lemite.com/product/list.html?cate_no=43"
pageNo = 1

# 웹 문서에 접속
headers = { 'User-Agent' : 'Mozilla/5.0'}
response = requests.get(targetUrl, headers=headers)
response.encoding = "utf-8"
html = response.text

if html is not None:
    html = BeautifulSoup(html, "html.parser")
    try : 
        products = html.find('ul', class_='prdList column4')
    except :
        print('파싱 불가')
    else :
        products = products.find_all('li', class_='item xans-record-')
        for item in products :
            productName = item.find('p', class_='name').text.split(':')[1].strip()
            detailPage = baseUrl + item.find('p', class_='name').find('a').attrs['href']
            startPos = detailPage.find('product_no=') + len('product_no=')
            endPos = detailPage.find('&', startPos)
            productNo = detailPage[startPos:endPos]

            thumbNailImg = 'https:'+item.find('div', class_='prdimg').find('img').attrs['src']
            description = item.find('li', class_='xans-record-').text.split(':')[1].strip()
            price = item.find('li', class_='xans-record-').find_next('li', class_='xans-record-').text.split(':')[1].strip().replace(',','').replace('원','').strip()

            # print(productNo, productName, thumbNailImg, description, price, detailPage)
            insertProduct(productNo, productName, thumbNailImg, description, price, detailPage)
            print("--------------------------------------------------------------------------------")
            # responseDetail = requests.get(detailPage, headers=headers)
            # responseDetail.encoding = "utf-8"
            # print(responseDetail.text)
         

