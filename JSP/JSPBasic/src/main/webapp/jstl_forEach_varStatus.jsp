<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.evenTr{
	background-color: yellow;}
	
	.firstHero {
	color:red;}
	
	.lastHero {
		font-weight: bold;
	}
</style>
</head>
<body>
	<%
		String[] heros = {"캡틴아메리카", "헐크", "아이언맨", "토르", "윤정"};
		pageContext.setAttribute("heros", heros);
	%>
	
	<!-- 짝수 번째 tr에 배경색 노란색 -->
	<table border="1">
		<tr>
			<td>index</td>
			<td>count</td>
			<td>hero</td>
		</tr>
		<c:forEach var="hero" items="${pageScope.heros }" varStatus="status">
			<c:choose>
				<c:when test="${status.index mod 2 == 0 }">
					<tr class='evenTr'>
						<td>${status.index }</td>
						<td>${status.count }</td>
						<td>${hero }</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td>${status.index }</td>
						<td>${status.count }</td>
						<td>${hero }</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</table>
	<hr/>
	<!-- 첫번째 영웅에 빨간색 글씨 -->
	<!-- 마지막 영웅에 글자 굵게 -->
		<table border="1">
		<tr>
			<td>index</td>
			<td>count</td>
			<td>hero</td>
		</tr>
		<c:forEach var="hero" items="${pageScope.heros }" varStatus="status">
			<c:choose>
				<c:when test="${status.first}">
					<tr class='firstHero'>
						<td>${status.index }</td>
						<td>${status.count }</td>
						<td>${hero }</td>
					</tr>
				</c:when>
				<c:when test="${status.last}">
					<tr class='lastHero'>
						<td>${status.index }</td>
						<td>${status.count }</td>
						<td>${hero }</td>
					</tr>
				</c:when>
				<c:otherwise>
					<tr>
						<td>${status.index }</td>
						<td>${status.count }</td>
						<td>${hero }</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</table>
	<hr/>

</body>
</html>