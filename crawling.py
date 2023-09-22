import requests
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
from selenium.webdriver.common.by import By

driver = webdriver.Chrome() 
driver.get('https://product.kyobobook.co.kr/category/KOR/35#?type=home')

# 원하는 태그 하나 elements 원하는 태그 배열로
tmp = driver.find_element(By.CLASS_NAME, "img_box")
tmp2 = tmp.find_element(By.TAG_NAME, 'img')
print(tmp2.get_attribute('src'))