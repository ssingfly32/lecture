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
	let MailValid = false;

	function printErrMsg(id, msg, isFocus) {
		let errMsg = `<div class='errMsg'>\${msg}</div>`;
		$(errMsg).insertAfter($(`#\${id}`));
		if(isFocus) {
			
		$(`#\${id}`).focus();
		}
		//$('.errMsg').hide(1000);
	}

	$(function(){
			// 아이디 작성을 마쳤을 때
		$('#userId').blur(function() {
			validUserId();
		});
		$('#userPwd2').blur(function() {
			validUserPwd();
		});
		
		$('.sendMail').click(function() {
			if($('#userEmail').val() != '') {
				$.ajax({
					url : 'sendMail.mem', // 데이터를 수신받을 서버 주소
					type : 'get', // 통신방식(GET, POST, PUT, DELETE)
					data : {
						"tmpUserEmail" : $('#userEmail').val()
					},
					dataType : 'json',
					async : false, // 데이터가 오면 실행해야해서
					success : function(data) {
						console.log(data);
						if(data.status == "success") {
							alert('메일 발송 성공')
						} else if(data.status == "fail") {
							alert('메일 발송 실패')
						}
						
					},
				});
			$('.codeDiv').show();
				
			} else {
				alert('이메일 주소를 기입하고 인증 버튼을 눌러주세요.');
				$('#userEmail').focus();
			}
		});
		
		// 코드 확인 버튼 클릭 시
		$('.confirmCode').click(function() {
			
			$.ajax({
				url : 'confirmCode.mem', // 데이터를 수신받을 서버 주소
				type : 'get', // 통신방식(GET, POST, PUT, DELETE)
				data : {
					"tmpMailCode" : $('#mailcode').val()
				},
				dataType : 'json',
				async : false, // 데이터가 오면 실행해야해서
				success : function(data) {
					console.log(data);
					if(data.activation == "success") {
						MailValid = true;
						alert('메일인증성공');
					}
					
				},
			});
		});
	});

	function validUserId() {
		let isValid = false;
		if($('#userId').val().length > 2 && $('#userId').val().length < 9) {
			$.ajax({
				url : 'duplicateUserId.mem', // 데이터를 수신받을 서버 주소
				type : 'get', // 통신방식(GET, POST, PUT, DELETE)
				data : {
					"tmpUserId" : $('#userId').val()
				},
				dataType : 'json',
				async : false, // 데이터가 오면 실행해야해서
				success : function(data) {
					console.log(data);
					if(data.responseCode != "00") {
						alert("DB에 문제가 있습니다! 다시 시도해주세요");
						console.log(data.errMsg);
					} else {
						if(data.isDuplicate == "true") {
							printErrMsg('userId', '아이디가 중복됩니다.',true)
						} else if(data.isDuplicate == "false") {
							printErrMsg('userId', '사용 가능한 아이디입니다.',false)
							isValid = true;
						}
					}
					
				},
			});
		}else {
			printErrMsg('userId', '아이디는3자 이상 8자 이하로 필수 항목입니다.', true);
		}
		return isValid;
	}
	
	// 비밀번호가 유효한 지 검사
	function validUserPwd() {
		let isValid = false;
		
		if($('#userPwd').val() != $('#userPwd2').val()) {
			$('#userPwd2').val('');
			$('#userPwd').val('');
			printErrMsg('userPwd', '비밀번호가 일치하지 않습니다.',true);
		} else {
			isValid = true;
		}
		return isValid;
	}

	// 회원 가입 버튼을 눌렀을 때
	function validCheck() {
		let isValid = false;
		let userIdValid = validUserId();
		let pwdValid = validUserPwd();
		
		if (userIdValid && pwdValid && MailValid) {
			isValid = true;
		}
		console.log(isValid);
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

		<form action="registerMember.mem" method="post" enctype="multipart/form-data">
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
				<label for="userPwd2" class="form-label">Password 확인:</label> <input
					type="password" class="form-control" id="userPwd2">
			</div>
			<div class="mb-3">
				<label for="userEmail" class="form-label">Email:</label> <input
					type="text" class="form-control" id="userEmail" name="userEmail">
				<button type="button" class="btn btn-info sendMail">이메일인증</button>
				<div class='codeDiv' style="display:none;">
				<input
					type="text" class="form-control" id="mailcode" placeholder="인증코드입력">
				<button type="button" class="btn btn-warning confirmCode">코드 확인</button>
				</div>
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