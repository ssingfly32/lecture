<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HelloServlet_POST 파일을 post 방식으로 호출해보자</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
function callServletAjax() {
	$.ajax({
          url: './hPost',
          type: 'post', // 통신방식(GET, POST, PUT, DELETE)
          data : {
        	"name" : '아이고~ 더버라'  
          },
          success: function (data) {
          	console.log("success");
          },
          error: function () {}, // 통신이 실패(부정적인 response) 했을 때 호출되는 콜백함수
          complete: function () {}, // 통신이 완료 되었을때 호출 되는 콜백함수
        });
}
</script>
</head>
<body>
	<h1>HelloServlet_POST 파일을 post 방식으로 호출해보자</h1>
	<form action="./hPost" method="post">
		<input type="text" name="name"/>
		<button type="submit">form 태그로 GET 방식 요청</button>
	</form>
	
	<div><button onclick="callServletAjax();">ajax로 서블릿 요청(post 방식)</button></div>
</body>
</html>