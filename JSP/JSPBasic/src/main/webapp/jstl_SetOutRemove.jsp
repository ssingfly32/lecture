<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="num" value="배고파" /> <!-- scope="session"처럼 사용 -->
	
	<%
		// pageContext.setAttribute("num", "배고파");
	%>
	
	<div>${pageScope.num }</div>
	
	<div><c:out value="${num }"></c:out> </div>
	
	<c:remove var="num"/>
	<div>${pageScope.num }</div>
</body>
</html>