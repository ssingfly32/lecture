<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>

</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<c:set var="contextPath" value="<%=request.getContextPath()%>"></c:set>
	<div class="container">
		<h1>상세 포인트 내역</h1>
		<div>${requestScope.memberInfo }</div>
		<div>${sessionScope.loginUser }</div>

		<div class="pointLog">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>적립일시</th>
						<th>적립사유</th>
						<th>적립포인트</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="point" items="${requestScope.pointLog }">
						<tr>
							<td>${point.when }</td>
							<td>${point.why }</td>
							<td>${point.howmuch }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="./../footer.jsp"></jsp:include>
</body>
</html>