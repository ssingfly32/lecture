# 단순 for문 (내가 원하는 횟수만큼 반복 시키고 싶을 때)
for i in range(10):
    print(i)

for i in range(1, 6) :
    print(i)

# 1 부터 100 까지 합
sum = 0
for i in range(1, 101) :
    sum += i
print ("1부터 100까지의 합 : ",sum)

# 2개의 for문을 이용하여 구구단 출력해보세요
for i in range(1, 10) :
   for j in range(1, 10) :
       print(i,"*",j,"=",i*j, end=',') # println이 따로없다.
