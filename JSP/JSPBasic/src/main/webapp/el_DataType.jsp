<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL로 표현 가능한 데이터 종류</title>
</head>
<body>
	<div>정수형 : ${10 }</div>
	<div>실수형 : ${3.141592 }</div>
	<div>문자열형 : ${"곧 있으면 태풍이 옵니다. 피해입지 않도록 주의하세요!"}</div> <!-- 작은따옴표도 가능 -->
	<div>논리형 : ${true}</div>
	<div>null : ${null}</div> <!-- 아무 글자도 안찍힘 -->
	
</body>
</html>