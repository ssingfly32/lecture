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
	<%
		String hobbies = "낮잠, 음악감상, 독서, 영화감상, 맛집투어, 게임";
		pageContext.setAttribute("hobbies", hobbies);
	%>
	
	<ul>
		<c:forTokens var="hobby" items="${hobbies }" delims=",">
			<li>${hobby }</li>
		</c:forTokens>
	</ul>
</body>
</html>