<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>

	function changeImgModal() {
		$('#changeImageModal').show();
	}
	function updateEmail() {
		$('#updateEmailModal').show();
	}

	function updateEmailClose() {
		$('#updateEmailModal').hide();
	}

	$(function() {
		// 아이디 작성을 마쳤을 때

		$('.sendMail').click(function() {
			if ($('#iuserEmail').val() != '') {
				$.ajax({
					url : 'sendMail.mem', // 데이터를 수신받을 서버 주소
					type : 'get', // 통신방식(GET, POST, PUT, DELETE)
					data : {
						"tmpUserEmail" : $('#iuserEmail').val()
					},
					dataType : 'json',
					async : false, // 데이터가 오면 실행해야해서
					success : function(data) {
						console.log(data);
						if (data.status == "success") {
							alert('메일 발송 성공')
						} else if (data.status == "fail") {
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
					if (data.activation == "success") {
						MailValid = true;
						alert('메일인증성공');
					}

				},
			});
		});
	});
	
</script>
<style>

	.changeImage {
		cursor: pointer;
	}
	.userPhoto {
		display: flex;
		justify-content: center;
	}
	
	.userPhoto img {
		width: 50px;
		height: 50px;
	}
</style>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<c:set var="contextPath" value="<%=request.getContextPath()%>"></c:set>



	<div class="container">
		<h1>마이 페이지</h1>
		<div>${requestScope.memberInfo }</div>
		<div>${sessionScope.loginUser }</div>

		<div class="userInfo">
			<div class="mb-3 mt-3 userPhoto">
				<img alt=""
					src="${contextPath }/${requestScope.memberInfo.memberImg }">

			</div>
			<div>
				<a onclick="changeImgModal();"><span class="badge bg-info changeImage">이미지 변경</span></a> <a
					href="${contextPath }/member/defaultImage.mem"><span class="badge bg-info">이미지 초기화</span></a>
			</div>
			<div class="mb-3 mt-3">

				<label for="userId" class="form-label">userId:</label> <input
					type="text" class="form-control" id="userId" name="userId"
					value="${requestScope.memberInfo.userId}" readonly>
			</div>
			<div class="mb-3">
				<label for="userPwd" class="form-label">Password:</label> <input
					type="password" class="form-control" id="userPwd" name="userPwd">
			</div>

			<div class="mb-3">
				<label for="userEmail" class="form-label">Email:</label> <input
					type="text" class="form-control" id="userEmail" name="userEmail"
					value="${requestScope.memberInfo.userEmail }">
				<button type="button" class="btn btn-info" onclick="updateEmail();">이메일
					변경</button>
			</div>

		</div>
		<div class="pointLog">
			<table class="table table-striped">
				<thead>
					<tr>
						<th>적립일시</th>
						<th>적립사유</th>
						<th>적립포인트</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="point" items="${requestScope.pointLog }">
						<tr>
							<td>${point.when }</td>
							<td>${point.why }</td>
							<td>${point.howmuch }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- The 이메일 변경 Modal -->
	<div class="modal" id="updateEmailModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">이메일 변경</h4>
					<button type="button" class="btn-close modifyModalClose"
						data-bs-dismiss="modifyEmpModal"></button>
				</div>

				<!-- Modal body -->
				<form action="updateEmail.mem" method="post">
					<div class="modal-body">
						<div class="mb-3">
							<label for="userEmail" class="form-label">변경할 Email:</label> <input
								type="text" class="form-control" id="iuserEmail"
								name="iuserEmail">
							<button type="button" class="btn btn-info sendMail">이메일인증</button>
							<div class='codeDiv' style="display: none;">
								<input type="text" class="form-control" id="mailcode"
									placeholder="인증코드입력">
								<button type="button" class="btn btn-warning confirmCode">코드
									확인</button>
							</div>
						</div>
					</div>

					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="submit" class="btn btn-success"
							data-bs-dismiss="modal" >변경</button>
						<button type="button" class="btn btn-danger"
							data-bs-dismiss="modal" onclick="updateEmailClose();">취소</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- The 이미지 변경 Modal -->
	<div class="modal" id="changeImageModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="changeImage.mem" method="post">

					<!-- Modal Header -->
					<div class="modal-header">
						<h4 class="modal-title">이미지 변경</h4>
						<button type="button" class="btn-close modifyModalClose"
							data-bs-dismiss="modifyEmpModal"></button>
					</div>

					<!-- Modal body -->
					<div class="modal-body">
						<div class="mb-3">
							<label for="cuserImg" class="form-label">변경할 이미지:</label> <input
								type="file" class="form-control" id="cuserImg" name="cuserImg">
						</div>
					</div>


					<!-- Modal footer -->
					<div class="modal-footer">
						<button type="submit" class="btn btn-success"
							data-bs-dismiss="modal">변경</button>
						<button type="button" class="btn btn-danger"
							data-bs-dismiss="modal" onclick="updateEmailClose();">취소</button>
					</div>
				</form>
			</div>
		</div>
	</div>



	<jsp:include page="./../footer.jsp"></jsp:include>
</body>
</html>