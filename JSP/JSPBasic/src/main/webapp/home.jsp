<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Home Page</h1>
	<div>${requestScope.loginUser }님 방가방가!</div>
	<div>${sessionScope.msg }</div>
	
	<a href='./loginEx1.jsp'>로그인하러 가기</a>
</body>
</html>