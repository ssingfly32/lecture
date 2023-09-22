list1 = [0, 0, 0] # 빈 배열 생성
list1[0] = 45
list1[1] = 100
list1[2] = 55

sum = list1[0] + list1[1] + list1[2]
print(list1)
print(sum)

list2 = []
list2.append(100)
list2.append(200)
list2.append(300)
print(list2)

list3 = []
for i in range(1, 6) : 
    list3.append(i)

print(list3)

list4 = [10, 20, 3.14, 40, '파이썬', False] # 자바스크립트의 배열과 닮음
print (list4)

list5 = [10, 20, 3, 40, 50]
print(list5[1])
print(list5[-1]) # 인덱스 값에 음수로 표현하면 리스트의 끝에서부터 탐색
print(list5[1:3]) # list5[1 ~ 3 - 1 ] 까지 모든 값을 출력
print(list5[3:]) # list5[3:] 3번째 부터 끝까지
print(list5[:4]) # list5 0 ~ 3 번째까지

# 리스트 관련 함수
myList = [30, 20, 10]
print("현재 리스트 : ", myList)
print ("리스트에서 pop()으로 꺼내기 : ", myList.pop()) # 맨 끝에서 하나 추출해서 삭제
print(myList) # 30, 20
myList.append(1)
print("현재 리스트 : ", myList)
myList.sort()
print(myList) # 1, 20, 30
myList.reverse()
print(myList) # 30, 20, 1
myList.insert(1, 100) # 1번째에 100 끼워넣기
print(myList) # 30, 100, 20, 1
myList.remove(20) # 20 삭제
print(myList)
myList.extend([100, 200, 300])
print(myList)
print("myList의 갯수 : ", len(myList))