<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 예제</title>
<script src="./js/commonJs.js"></script>
<script>
	window.onload = function () {
		if(getParameter("status") === 'fail') {
			alert("로그인 실패");
		}
	};
</script>
</head>
<body>
	<form action="./loginProcEx1.do" method="post">
	<div>아이디 : <input type="text" name="userId"/></div>
	<div>비밀번호 : <input type="password" name="userPwd"/></div>
	<div>
		<button type="reset">취소</button>
		<button type="submit">로그인</button>
	</div>
	</form>
	<div>${sessionScope.msg }</div>
	<div>${requestScope.loginUser }님 방가방가!</div>
</body>
</html>