import requests
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains

driver = webdriver.Chrome() 
driver.get('https://product.kyobobook.co.kr/category/KOR/350101#?page=1&type=all&per=50&sort=new')
time.sleep(1)

# 원하는 태그 하나 elements 원하는 태그 배열로

# print(tmp.get_attribute('class'))

# tmp = driver.find_elements(By.CLASS_NAME, 'prod_name')
# for j in range(20) :
#     print("tmp",tmp[j].text)
tmpStr = []
prodTitle = []
salePrice = []
price = []
isbn = []
keyWord = []
mainImg = []
detailImg = []
author = []
pubCom = []
pubDate = []
page = []
size = []
volume = []
writer = []
writerInfo = []
infoIntro = []
infoDetail = []
bookItems = []
intoBook = []
pubReview = []
issn = []
authorTmp = []

# 도서 이름
# 소비자가 sale_price
# 판매가 price
# isbn tbl_row 예외
# 키워드 tab_text 예외
# 상품 이미지 portrait_img_box
# 상품 정보 이미지 detail_img 예외
# 작가 author
# 출판사 prod_info_text publish_date
# 발행일(출판일) tbl_row
# 페이지수 tbl_row
# 크기 tbl_row
# 총 권수 tbl_row
# 원서 / 저자명 tbl_row 예외
# 저자 소개 writer_info_box
# 소개글 intro intro_bottom
# 소개글 detail intro_bottom
# 작가의 말 
# 목차 book_contents_item
# 책 속으로 auto_overflow_inner
# 출판사 서평 auto_overflow_inner

# pageNum = driver.find_elements(By.CLASS_NAME, 'btn_page_num')
# endPageNum = int(pageNum[-1].text) -1
# tmp = (driver.find_elements(By.CLASS_NAME, 'prod_name'))
# for j in range(20):
#     tmpStr.append(tmp[j].text)
#     print(tmpStr)

# print(len(tmpStr))

for i in range(2) :
    for i in range(48,50) :
        driver.find_elements(By.CLASS_NAME, 'prod_name')[i].click()
        prodTitle.append(driver.find_element(By.CLASS_NAME, "prod_title").text)
        salePrice.append(driver.find_element(By.CLASS_NAME, "sale_price").find_element(By.CLASS_NAME, "val").text)
        mainImg.append(driver.find_element(By.CLASS_NAME, "portrait_img_box").find_element(By.TAG_NAME, "img").get_attribute('src'))
        if len(driver.find_element(By.CLASS_NAME, "author").find_elements(By.TAG_NAME, "a")) > 1 :
            for j in range(len(driver.find_element(By.CLASS_NAME, "author").find_elements(By.TAG_NAME, "a"))) :
                authorTmp.append(driver.find_element(By.CLASS_NAME, "author").find_elements(By.TAG_NAME, "a")[j].text)
            print(', '.join(authorTmp))
            author.append(', '.join(authorTmp))
        else: author.append(driver.find_element(By.CLASS_NAME, "author").find_element(By.TAG_NAME, "a").text)
        pubCom.append(driver.find_element(By.CLASS_NAME, 'publish_date').find_element(By.TAG_NAME, 'a').text)
        ths = driver.find_element(By.CLASS_NAME, 'tbl_row').find_elements(By.TAG_NAME, 'th')
        for j in range (len(ths)) :
            if ths[j].text == "발행(출시)일자" :
                pubDate.append(driver.find_element(By.CLASS_NAME, 'tbl_row').find_elements(By.TAG_NAME, 'td')[j].text)
            else : pubDate.append("null")
            if ths[j].text == "ISBN" :
                isbn.append(driver.find_element(By.CLASS_NAME, 'tbl_row').find_elements(By.TAG_NAME, 'td')[j].text)
            else : isbn.append("null")    
            if ths[j].text == "쪽수" :
                page.append(driver.find_element(By.CLASS_NAME, 'tbl_row').find_elements(By.TAG_NAME, 'td')[j].text)
            else: page.append("null")
            if ths[j].text == "크기" :
                size.append(driver.find_element(By.CLASS_NAME, 'tbl_row').find_elements(By.TAG_NAME, 'td')[j].text)
            else : size.append("null")
            if ths[j].text == "총권수" :
                volume.append(driver.find_element(By.CLASS_NAME, 'tbl_row').find_elements(By.TAG_NAME, 'td')[j].text)
            else : volume.append("null")
            if ths[j].text == "원서명/저자명" :
                writer.append(driver.find_element(By.CLASS_NAME, 'tbl_row').find_elements(By.TAG_NAME, 'td')[j].text)
            else : writer.append("null")
            if ths[j].text == "ISSN" :
                issn.append(driver.find_element(By.CLASS_NAME, 'tbl_row').find_elements(By.TAG_NAME, 'td')[j].text)
            else : issn.append("null")
    
        try : 
            writerInfo.append(driver.find_element(By.CLASS_NAME, 'writer_info_box').find_element(By.TAG_NAME, 'p').text)
        except :
            writerInfo.append("null")
        try :
            infoIntro.append(driver.find_element(By.CLASS_NAME, 'intro_bottom').find_elements(By.CLASS_NAME, 'info_text')[0].text)
        except : infoIntro.append("null")
        try:
            infoDetail.append(driver.find_element(By.CLASS_NAME, 'intro_bottom').find_elements(By.CLASS_NAME, 'info_text')[1].text)
        except :
            infoDetail.append("null")
        try :
            bookItems.append(driver.find_element(By.CLASS_NAME, 'book_contents_item').text)
        except :
            bookItems.append("null")
        try :
            intoBook.append(driver.find_element(By.CLASS_NAME, 'book_inside').find_element(By.CLASS_NAME, 'info_text').text)
        except : intoBook.append("null")
        try :    
            pubReview.append(driver.find_element(By.CLASS_NAME, 'book_publish_review').find_element(By.CLASS_NAME, 'info_text').text) 
        except :
            pubReview.append("null")     
       
        
        


        driver.back()
        time.sleep(3)
    your_el = driver.find_element(By.CLASS_NAME, 'next')
    
                
    # 해당 요소가 화면에 존재하지 않으면 클릭할 수 없으므로 요소가 보일때까지 스크롤하는 액션
    actions = ActionChains(driver).move_to_element(your_el)
    actions.perform()
    your_el.click()
    time.sleep(2)
    

print(prodTitle, salePrice, mainImg, author, pubCom, pubDate, isbn, page, size, volume, writer, issn, writerInfo, infoIntro, infoDetail, bookItems, intoBook, pubReview)
print(len(prodTitle),"개 크롤링 완료")
    










# print(tmp.get_attribute('src'))