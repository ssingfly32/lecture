<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<title>index.jsp</title>
<script>
 	$(document).ready(function() {
 		getEmployees();
 	});
 	
 	function getEmployees() {
 		$.ajax({
	          url: './getEmp.do', // 데이터를 수신받을 서버 주소
	          type: 'get', // 통신방식(GET, POST, PUT, DELETE)
	          success: function (data) {
	            console.log(data);
	          },
	          error: function () {}, // 통신이 실패(부정적인 response) 했을 때 호출되는 콜백함수
	          complete: function () {}, // 통신이 완료 되었을때 호출 되는 콜백함수
	        });
 	}
</script>
</head>
<body>
	<div class="container">
		<h1>Employees With Ajax</h1>
		
		<div class="employees"></div>
	</div>
	
</body>
</html>