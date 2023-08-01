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
		location.href = './hGET?name=도우너';
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
	<h1>HelloServlet_GET 파일을 get방식으로 호출해보자</h1>
	<button onclick="callServlet();">location.href로 서블릿 요청(get 방식)</button>
	<div>
		<a href='./hGET?name=둘리'>a 태그로 서블릿 요청</a>
	</div>
	<form action="./hGET" method="get">
		<input type="text" name="name" />
		<!-- <input> 태그의 name 속성은 <input> 요소의 이름을 명시합니다. name 속성은 폼(form)이 제출된 후 
		서버에서 폼 데이터(form data)를 참조하기 위해 사용되거나, 자바스크립트에서 요소를 참조하기 위해 사용됩니다. -->
		<button type="submit">form 태그로 GET 방식 요청</button>
	</form>
	<div>
		<button onclick="callServletAjax();">ajax로 서블릿 요청(get 방식)</button>
	</div>
</body>
</html>