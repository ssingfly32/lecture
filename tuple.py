# 튜플은 읽기 전용 배열
tuple1 = (10, 20, 3, 40, 50)
print(tuple1[4])
print(tuple1[1:3])

# tuple 삭제
#  del(tuple1)

myList = list(tuple1)
print(myList)

myList2 = [1, 2, 3]
myTuple = tuple(myList2)
print(myTuple)

