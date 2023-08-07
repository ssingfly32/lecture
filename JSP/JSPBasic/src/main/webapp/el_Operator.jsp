<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL에서 사용 가능한 연산자</title>
</head>
<body>
	<div>\${5+2} : ${5+2 } </div> <!-- 역슬러시 : 이스케이프 시퀀스. 뒤에 것이 실행되지 않게 -->
	<div>\${5 div 2 } : ${5 div 2 }</div>
	<div>\${5 mod 2 } : ${5 mod 2 }</div>
	<div>\${5 gt 2 } : ${5 gt 2 }</div>
	<div>\${5 le 2 } : ${5 le 2 }</div>
	<div>\${5 gt 2 and 3 lt 4 } : ${5 gt 2 and 3 lt 4 }</div>
	<div>\${5 gt 45? "참":"거짓" } : ${5 gt 45? "참":"거짓" }</div>
	
	<%
		String input = null;
	%>
	<div>\${empty input } : ${empty input }</div>
</body>
</html>