<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import ="com.ksh.vo.Member" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		//Member member = new Member();
	%>
	
	<!-- 기본 생성자를 이용하여 Member 객체 생성 -->
	<!-- 기본 생성자를 이용하여 객체를 생성하되, setProperty를 이용해 멤버변수를 초기화 해서 사용한다 -->
	<jsp:useBean id="m1" class="com.ksh.vo.Member"></jsp:useBean>
	<jsp:setProperty property="userId" name="m1" value="dooly"/>
	<jsp:setProperty property="userPwd" name="m1" value="1234"/>
	<div><%=m1.toString() %></div>
	
	<div>m1 객체의 유저아이디 : <jsp:getProperty property="userId" name="m1"/></div>
</body>
</html>