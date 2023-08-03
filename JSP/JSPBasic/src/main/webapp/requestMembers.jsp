<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Request 객체의 다양한 멤버들</title>
</head>
<body>
	<h1>Request 객체의 다양한 멤버들</h1>
	
	
	<%
		out.print("*현재 실행되는 contextPath : " + request.getContextPath() + "<br/>");
		out.print("현재 요청 방식: " + request.getMethod() + "<br/>");
		out.print("현재 프로토콜: " + request.getProtocol() + "<br/>");
		out.print("*현재 쿼리스트링: " + request.getQueryString() + "<br/>");
		out.print("*주어진 path의 물리적 경로 : " + request.getRealPath("./image") + "<br/>");
		out.print("요청된 클라이언트의 ip : " + request.getRemoteAddr() + "<br/>");
		out.print("*요청된 uri : " + request.getRequestURI() + "<br/>");
		
	%>
</body>
</html>