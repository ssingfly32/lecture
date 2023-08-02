<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./Triangle.do" method="get">
		<div>삼각형의 밑변<input type="text" name="base"></div>
		<div>삼각형의 높이<input type="text" name="height"></div>
		<div><input type="submit" value="제출"/></div>
	</form>
	<div>밑변 : ${triangle.base}</div>
	<div>높이 : ${triangle.height}</div>
	<div>넓이 : ${triangle.area}</div>
</body>
</html>