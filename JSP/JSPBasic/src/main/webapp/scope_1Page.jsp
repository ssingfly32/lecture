<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>scope_1Page.jsp</h1>
	
	<%
		// 각 내장 객체의 생명주기를 알아보기 위해 내장객체의 영역에 데이터를 바인딩 해보자
		pageContext.setAttribute("name", "page data");
		request.setAttribute("name", "request data");
		session.setAttribute("name", "session data");
		application.setAttribute("name", "application data");
	%>
	
	<%
		// 각 내장 객체영역에 바인딩 된 정보를 확인
		out.print("pageContext : " +  pageContext.getAttribute("name")+ "<br/>");
		out.print("request : " +  request.getAttribute("name")+ "<br/>");
		out.print("session : " +  session.getAttribute("name")+ "<br/>");
		out.print("application : " +  application.getAttribute("name")+ "<br/>");
		
		request.getRequestDispatcher("scope_2Page.jsp").forward(request, response);
	%>
	
	
</body>
</html>