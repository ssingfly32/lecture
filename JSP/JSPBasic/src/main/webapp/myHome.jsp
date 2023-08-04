<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>myHome.jsp</h1>
	<a href='./loginEx2.jsp'>로그인</a>
	
	<%
		// 로그인을 했을 경우에만 화면에 출력
		if(session.getAttribute("loginMember") != null) {
			out.print("<div>" + (String)session.getAttribute("loginMember") +"님 환영합니다!</div>");
			out.print("<form action='./logout.do'><button type='submit'>로그아웃</button> </form>");
		}
	%>
	
	
	
	<!-- EL 표현방식 
	<div>${sessionScope.loginMember}님 환영합니다!</div>-->
</body>
</html>