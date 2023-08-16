<%@page import="com.miniproj.dao.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Test</h1>

<%
	java.sql.Connection con = DBConnection.getInstance().dbConnect();

	out.print(con.toString());
	
	con.close();
%>
</body>
</html>