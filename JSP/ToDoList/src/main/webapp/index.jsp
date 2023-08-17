<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
 <script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<title>To Do List</title>
<script>
	let ToDoData = null;
	let currentDate = new Date().toLocaleDateString();
	$(document).ready(function() {
		getToDo();
	});
	function insertModalOpen() {
		$('#myInsertModal').show();
	}
	function getToDo() {
		$.ajax({
			url : './getToDo.do', // 데이터를 수신받을 서버 주소
			type : 'get', // 통신방식(GET, POST, PUT, DELETE)
			dataType : 'json',
			async : false, // 데이터가 오면 실행해야해서
			success : function(data) {
				console.log(data);
				ToDoData = data;
				if (data.responseCode == "00") {
					outputToDo(data);
				} 
				else if (data.responseCode == "00" && data.count == "0") {
					alert("조회할 데이터가 없습니다. (직원 없음)");
				} else if (data.responseCode != "00") {
					alert("데이터를 가져오지 못했습니다");
				}
			},
			error : function() {
			}, // 통신이 실패(부정적인 response) 했을 때 호출되는 콜백함수
			complete : function() {
			}, // 통신이 완료 되었을때 호출 되는 콜백함수
		});
	};
	
	
	function outputToDo(json) {
		let output = `<table class="table table-hover"><h2>오늘의 할 일 \${currentDate}</h2><tbody>`;
		$.each(json.todolist, function(i,e) {
			output += `<tr><td>\${e.no} \${e.todo}</td>`;
			output += `<td>\${e.end_date}</td>`;
			output += `<td>\${e.complete}</td></tr>`;
		});
		output += `</tbody></table>`
		$('.outPutToDo').html(output);
	}
</script>
<style>
	.saveToDoIcon img{
		position: fixed;
	bottom: 10px;
	right: 10px;
	width: 50px;
	height: 50px;
	border-radius: 25px;
	}
</style>
</head>
<body>
<div class="container mt-3">
<h2 class="currentDate"></h2> 
<div class="outPutToDo"></div>
</div>
<div class="saveToDoIcon">
		<img src="./images/insert.png" onclick="insertModalOpen();" />
	</div>
	<!-- 인서트 모달 창 -->
	<div class="modal" id="myInsertModal">
  <div class="modal-dialog">
    <div class="modal-content">

      <!-- Modal Header -->
      <div class="modal-header">
        <h4 class="modal-title">할 일 추가하기</h4>
        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
      </div>

      <!-- Modal body -->
      <div class="modal-body">
        <div class="mb-3 mt-3">
    	<label for="email" class="form-label">할 일:</label>
    	<input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
  		</div>
 
      </div>

      <!-- Modal footer -->
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">취소</button>
        <button type="button" class="btn btn-primary" data-bs-dismiss="modal">추가</button>
      </div>

    </div>
  </div>
</div>
</body>
</html>