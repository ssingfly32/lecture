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
	<c:forEach var="i" begin="1" end="10">
		<div>${i }</div>
	</c:forEach>
	
	<hr/>
	
	<c:forEach var="dan" begin="1" end="9">
		<c:forEach var="i" begin="1" end="9">
			<c:choose>
				<c:when test="${i % 2 == 0 }">
					<b>${dan } * ${i } = ${dan*i }</b> &nbsp;&nbsp;&nbsp;
				</c:when>
				<c:otherwise>
					${dan } * ${i } = ${dan*i } &nbsp;&nbsp;&nbsp;
				</c:otherwise>
			</c:choose>
		</c:forEach>
		<br/>
	</c:forEach>
</body>
</html>