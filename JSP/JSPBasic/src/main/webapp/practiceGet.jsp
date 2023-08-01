<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>

	function callServlet() {
		location.href='./pGet?pname=도우너';
	}
	
	function callServletAjax() {
		$.ajax({
			url : './hGET?name=마이콜',
			type : 'get', // 통신방식(GET, POST, PUT, DELETE)
			success : function(data) {
				console.log("success");
			},
			error : function() {
			}, // 통신이 실패(부정적인 response) 했을 때 호출되는 콜백함수
			complete : function() {
			}, // 통신이 완료 되었을때 호출 되는 콜백함수
		});
	}
</script>
</head>
<body>
	<h1>get방식 호출</h1>
	<button onclick=callServlet();>location.href로 서블릿 요청</button>
	<div>
		<a href='./pGet?pname=둘리'>a 태그로 서블릿 요청</a>
	</div>
	<form action="./pGet" method="get">
		<input type="text" name="pname" />
		<button type="submit">form태그로 get 방식 요청</button>
	</form>
	<div>
		<button onclick=callServletAjax();>ajax로 get 방식 요청</button>
	</div>
</body>
</html>