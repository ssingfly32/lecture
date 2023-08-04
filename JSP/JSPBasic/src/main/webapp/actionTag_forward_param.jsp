<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		request.setCharacterEncoding("utf-8");
	%>

	<!-- RequestDispatcher에 의해 페이지 이동 된다(url 주소값이 바뀌지 않는다) -->
 	<jsp:forward page="actionTag_forward_param_1.jsp">
 		<jsp:param value="둘리" name="nickName"/>
 		<jsp:param value="21" name="age"/>
 	</jsp:forward>
</body>
</html>