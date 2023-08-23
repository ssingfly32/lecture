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

<style>
.readLikeCnt {
	diplay: flex;
	jstify-content: space-between;
}
</style>
<script>

	function showDeleteModal() {
		$('#delModal').show();
	}
	
	function deleteBoard() {
		let boardNo = '${requestScope.board.no}';
		$.ajax({
			url : 'delBoard.bo', // 데이터를 수신받을 서버 주소
			type : 'get', // 통신방식(GET, POST, PUT, DELETE)
			data : {
				"boardNo" : boardNo
			},
			dataType : 'json',
			async : false, // 데이터가 오면 실행해야해서
			success : function(data) {
				console.log(data);
				if(data.status == 'success') {
					location.href='listAll.bo';
				}
			},
		});
	}
</script>
</head>
<body>
	<jsp:include page="./../header.jsp"></jsp:include>
	<c:set var="contextPath" value="<%=request.getContextPath()%>" />

	<div class="container">
		<h1>게시판 글 조회</h1>


		<div class="mb-3 mt-3">
			<label for="boardNo" class="form-label">글번호 :</label> <input
				type="text" class="form-control" id="boardNo"
				value="${requestScope.board.no }" readonly>
		</div>
		<div class="mb-3 mt-3">
			<label for="writer" class="form-label">작성자 :</label> <input
				type="text" class="form-control" id="writer"
				value="${requestScope.board.writer }" readonly>
		</div>
		<div class="mb-3">
			<label for="title" class="form-label">제목 :</label> <input type="text"
				class="form-control" id="title" value="${requestScope.board.title }"
				readonly>
		</div>
		<div class="readLikeCnt">
			<div class="readCount">
				조회수 : <span class="badge rounded-pill bg-success">${requestScope.board.readcount }</span>
			</div>
			<div class="likeCount">
				좋아요 : <span class="badge rounded-pill bg-info">${requestScope.board.likecount }</span>
			</div>
		</div>

		<div class="mb-3">${requestScope.board.content }</div>

		<c:if test="${requestScope.uploadFile != null }">
			<div class="mb-3">

				<img alt=""
					src="${contextPath }/${requestScope.uploadFile.newFileName }" /> <span>${requestScope.uploadFile.originalFileName }</span>
			</div>
		</c:if>
		<div class="mb-3">
			<c:choose>
				<c:when test="${sessionScope.loginUser != null }">
					<c:if
						test="${sessionScope.loginUser.userId == requestScope.board.writer }">
						<button type="button" class="btn btn-secondary">수정</button>
						<button type="button" class="btn btn-warning"
							onclick='showDeleteModal();'>삭제</button>

					</c:if>
					<button type="button" class="btn btn-success">답글달기</button>

				</c:when>
				<c:otherwise>
					<button type="button" class="btn btn-secondary" disabled>수정</button>
					<button type="button" class="btn btn-warning" disabled>삭제</button>
					<button type="button" class="btn btn-success" disabled>답글달기</button>
				</c:otherwise>
			</c:choose>
			<button type="button" class="btn btn-info"
				onclick="location.href='listAll.bo';">목록으로 가기</button>
		</div>


	</div>


	<jsp:include page="./../footer.jsp"></jsp:include>

	<!-- The Modal -->
	<div class="modal" id="delModal" style="display: none;">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">알림</h4>
					<button type="button" class="btn-close" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">${requestScope.board.no }번 글 삭제?</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-warning" onclick="deleteBoard();">삭제</button>

					<button type="button" class="btn btn-danger"
						data-bs-dismiss="modal">취소</button>
				</div>

			</div>
		</div>
	</div>
</body>
</html>