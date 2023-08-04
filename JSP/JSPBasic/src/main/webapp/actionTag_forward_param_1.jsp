<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>actionTag_forward_param_1.jsp</h1>
	
	<!-- 오리지널 표현방식 -->
	<%=request.getParameter("nickName")%>
	<%=request.getParameter("age")%>
	
	<!-- EL 표현식 (권장) -->
	<div>${param.nickName }</div>
	<div>${param.age }</div>
</body>
</html>