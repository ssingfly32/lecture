# 딕셔너리 : 데이터를 키와 값의 쌍으로 표현

dict1 = {1: 'one', 2: 'two', 3:'three'}
print(dict1)

student = {'학번' : 230919, '이름' : '홍길동', '나이' : 20}
print(student)

student['연락처'] = '010-1234-5678'
print(student)

print(student['나이'])

# 키들의 집합
print(student.keys())
print(list(student.keys()))
# 값들의 집합
print(list(student.values()))

# 딕셔너리를 tuple로 변환
print(student.items())

if '학번' in student :
    print(student['학번'])
else :
    print('학번이 없습니다.')

# student에 있는 모든 key와 value를 출력
for s in student.keys() :
    print(s, ":",student[s])