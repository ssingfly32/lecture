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
	<c:if test="${sessionScope.loginUser == null }">
		<c:redirect url="../member/login.jsp"></c:redirect>
	</c:if>
	<jsp:include page="./../header.jsp"></jsp:include>

	<div class="container">
		<h1>게시판 답글 작성</h1>
		<form action="reply.bo" method="post">
			<div class="mb-3 mt-3">
				<label for="writer" class="form-label">작성자 :</label> <input
					type="text" class="form-control" id="writer"
					 name="writer" value="${sessionScope.loginUser.userId }" readonly>
			</div>
			<div class="mb-3">
				<label for="title" class="form-label">제목:</label> <input
					type="text" class="form-control" id="title"
					name="title">
			</div>
			<div class="mb-3">
				<textarea rows="40" style="width:100%" id="content" name="content"></textarea> 
			</div>
			<input type="hidden" name="no" value="${param.no }" />
			<input type="hidden" name="ref" value="${param.ref }" />
			<input type="hidden" name="step" value="${param.step }" />
			<input type="hidden" name="reforder" value="${param.reforder }" />
			<div class="mb-3">
				<button type="reset" class="btn btn-secondary">취소</button>
				<button type="submit" class="btn btn-success">저장</button>
			</div>
		</form>
	</div>
	<jsp:include page="./../footer.jsp"></jsp:include>
</body>
</html>