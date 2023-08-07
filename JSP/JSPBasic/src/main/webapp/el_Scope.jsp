<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- request 영역에 바인딩 정보 출력 -->
	<div>${requestScope.num1 } + ${requestScope.num2 } = ${result }</div> <!-- requestScope생략이 가능함 -->
	
	<!-- session 영역에 바인딩된 정보 출력 -->
	<!-- el을 사용하여 객체의 멤버에 접근할 떄는 private 한 멤버변수이름을 잘 확인하여 사용할 것
	el 표현식이 객체의 getter / setter를 접근하여 사용함 -->
	${sessionScope.member.userId }
	${sessionScope.member.memo }
</body>
</html>