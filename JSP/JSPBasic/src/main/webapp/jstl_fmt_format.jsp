<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="now" value="<%=new java.util.Date()%>"/>
	<div>time : <fmt:formatDate value="${now }" type="time"/> </div>
	<div>date : <fmt:formatDate value="${now }" type="date"/> </div>
	<div>both : <fmt:formatDate value="${now }" type="both"/> </div>
	<div>both(full) : <fmt:formatDate value="${now }" type="both" timeStyle="full"/> </div>
	<div>both(full) : <fmt:formatDate value="${now }" type="both" dateStyle="full"/> </div>
	
	<hr />
	<c:set var="num" value="${1234.567 }"/>
	<div><fmt:formatNumber value="${num }" type="currency"></fmt:formatNumber></div>
	<div><fmt:formatNumber value="${num }" type="percent"></fmt:formatNumber></div>
	
	
</body>
</html>