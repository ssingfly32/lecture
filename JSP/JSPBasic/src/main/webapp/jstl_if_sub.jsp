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
	<div>좋아하는 노래 : ${param.favSong }</div>
	
	<c:if test="${param.favSong eq 'ditto' }">
	
		<div style="color:red">좋아하는 노래 : ${param.favSong }</div>
	</c:if>
	<c:if test="${param.favSong eq 'seven' }">
	
		<div style="color:blue">좋아하는 노래 : ${param.favSong }</div>
	</c:if>
	<c:if test="${param.favSong eq 'oldSong' }">
	
		<div style="color:green">좋아하는 노래 : ${param.favSong }</div>
	</c:if>
</body>
</html>