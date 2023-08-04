<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>scope_3Page.jsp</h1>
	
	
	
	<%
		// 각 내장 객체영역에 바인딩 된 정보를 확인
		out.print("pageContext : " +  pageContext.getAttribute("name")+ "<br/>");
		out.print("request : " +  request.getAttribute("name")+ "<br/>");
		out.print("session : " +  session.getAttribute("name")+ "<br/>");
		// 다른 웹브라우저에서는 다른 세션으로 인식해서 null 나옴
		out.print("application : " +  application.getAttribute("name")+ "<br/>");
	%>
	

</body>
</html>