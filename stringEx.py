str = "우리나라 대한민국"
print (str[1:3])
print(str[5:])
str = "최고" * 5
print(str)
print(len(str))

str = "Python is Best Programming Language"
print(str.upper())
print(str.lower())
print(str.swapcase())
print(str.title()) # 첫글자를 대문자로 변경

str = "Python is very simple. 정말? python이 그래?"
print(str.find("Python")) # indexOf
print(str.rfind("Python")) # lastIndexOf
print(str.find("good")) # 없으면 -1

print(str.startswith("Python")) # True
print(str.endswith("정말")) # False

str = " 파  이   썬    "
print(str.strip()) # 앞 뒤 공백 제거
print(str.lstrip()) # 앞 쪽 공백 제거
print(str.rstrip()) # 뒤 쪽 공백 제거
print(str.replace(" ", ""))

str = "하나:둘:셋:넷"
print(str.split(":"))

print('1234'.isdigit()) # 숫자?
print('가나다'.isdigit())
print('가나다'.isalpha()) # 문자?
print('abcd'.islower()) # only 소문자?
print('abcdE'.islower())
print('   '.isspace()) # 공백?
