<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./useRequest2" method="post">
	<div>아이디 : <input type="text" name="userId"></div>
	<div>비밀번호 : <input type="password" name="userPw"></div>
	<div>이름 : <input type="text" name="userName"></div>
	<div><input type="submit" value="제출"></div>
	</form>
	<hr/>
	<div>아이디 : ${userInfo.userId}</div>
	<div>비밀번호 : ${userInfo.userPw}</div>
	<div>이름 : ${userInfo.userName}</div>
	
</body>
</html>