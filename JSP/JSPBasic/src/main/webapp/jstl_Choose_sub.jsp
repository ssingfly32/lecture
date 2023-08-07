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
	<c:choose>
		<c:when test="${param.favSeason eq 'spring'}">
			<div>봄</div>
		</c:when>
		<c:when test="${param.favSeason eq 'summer'}">
			<div>여름</div>
		</c:when>
		<c:when test="${param.favSeason eq 'autumn'}">
			<div>가을</div>
		</c:when>
		<c:otherwise>
			<div>겨울</div>
		</c:otherwise>
	</c:choose>
</body>
</html>