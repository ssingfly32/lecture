<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="../header.jsp"></jsp:include>
<div class="container">
		<h1>로그인</h1>
		<form action="login.mem" method="post">
			<div class="mb-3 mt-3">
				<label for="userId" class="form-label">userId:</label> <input
					type="text" class="form-control" id="userId"
					 name="userId">
			</div>
			<div class="mb-3">
				<label for="userPwd" class="form-label">Password:</label> <input
					type="password" class="form-control" id="userPwd"
					name="userPwd">
			</div>
			<div class="mb-3">
				<button type="reset" class="btn btn-secondary">취소</button>
				<button type="submit" class="btn btn-success" >로그인</button>
			</div>
		</form>
	</div>
	<jsp:include page="./../footer.jsp"></jsp:include>
</body>
</html>