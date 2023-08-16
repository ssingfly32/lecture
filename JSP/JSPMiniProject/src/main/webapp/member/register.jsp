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
	function printErrMsg(id, msg) {
		let errMsg = `<div class='errMsg'>\${msg}</div>`;
		$(errMsg).insertAfter($(`#\${id}`));
		$(`#\${id}`).focus();
		$('.errMsg').hide(3000)
	}

	$(function(){
		$('#userId').blur(function() {
			// 아이디 작성을 마쳤을 때
			if($(this).val().length < 1 || $(this).val().length >= 9) {
				printErrMsg('userId', '아이디는 8자 이하로 필수 항목입니다.')
			}
		});
		
		// 아이디를 작성 할 때
		$('#userId').keyup(function() {
			if($(this).val().length > 2) {
				$.ajax({
					url : 'duplicateUserId.mem', // 데이터를 수신받을 서버 주소
					type : 'get', // 통신방식(GET, POST, PUT, DELETE)
					data : {
						"tmpUserId" : $(this).val()
					},
					dataType : 'json',
					async : false, // 데이터가 오면 실행해야해서
					success : function(data) {
						console.log(data);
						
					},
				});
			}
		});
	});


	// 회원 가입 버튼을 눌렀을 때
	function validCheck() {
		let isValid = false;
		
		
		
		return isValid;
	}
</script>
<style>
	.errMsg {
		color : red;
		font-size: 14px;
		font-weight: bold;
	}
</style>
</head>
<body>
	<jsp:include page="./../header.jsp"></jsp:include>
	<!-- <iframe src="./membership.txt"></iframe>  약관-->
	<div class="container">
		<h1>회원가입</h1>

		<form action="registerMember.mem" method="post">
			<div class="mb-3 mt-3">
				<label for="userId" class="form-label">userId:</label> <input
					type="text" class="form-control" id="userId"
					 name="userId">
			</div>
			<div class="mb-3">
				<label for="userPwd" class="form-label">Password:</label> <input
					type="password" class="form-control" id="userPwd"
					name="userPwd">
			</div>
			<div class="mb-3">
				<label for="userEmail" class="form-label">Email:</label> <input
					type="text" class="form-control" id="userEmail" name="userEmail">
				<button type="button" class="btn btn-info">이메일인증</button>
			</div>
			<div class="mb-3">
				<label for="userImg" class="form-label">Your photo:</label> <input
					type="file" class="form-control" id="userImg" name="userImg">
			</div>
			<div class="mb-3">
				<button type="reset" class="btn btn-secondary">취소</button>
				<button type="submit" class="btn btn-success" onclick="return validCheck();">회원가입</button>
			</div>
		</form>
	</div>
	<jsp:include page="./../footer.jsp"></jsp:include>
</body>
</html>