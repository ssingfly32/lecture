<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>session 내장 객체의 주요 멤버</h1>
	
	<%
		session.setAttribute("name", "홍길동"); // 세션에 네임이란 이름으로 홍길동을 바인딩
	%>
	
	<div>세션아이디 : <%=session.getId() %></div>
	
	<%
		session.invalidate(); // 세션 무효화
	%>
	<div>세션 아이디 무효화 후 : <%=session.getId() %></div>
	
	<div><%--%=session.getAttribute("name") --%></div>
</body>
</html>