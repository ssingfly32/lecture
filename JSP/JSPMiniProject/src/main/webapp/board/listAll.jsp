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
	
	$(function () {
		$('.board').each(function(){
			let postDate = new Date($(this).children().eq(3).html());
			let curDate = new Date();
			
			let title = $(this).children().eq(1).html();
			
			let diff = (curDate - postDate) / 1000/ 60/ 60;
			if (diff < 24) {
				let output = "<span><img src='./../images/new.png'/ width='32px'></span>";
				 $(this).children().eq(1).html(output + title);
			}
		}); // 태그를 선택해서 each 쓰면 태그 만날때마다 function 돈다.
	});	
</script>
<style>
	.delBoard td {
		color : #333;
		text-decoration: line-through;
	}
</style>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="container">
		<h1>게시판 전체 목록 조회</h1>
		<div class="boardList">
			<c:choose>
				<c:when test="${boardList != null}">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>글 번호</th>
								<th>제목</th>
								<th>작성자</th>
								<th>작성일</th>
								<th>조회수</th>
								<th>좋아요</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="board" items="${boardList }">
							<c:choose>
								<c:when test="${board.isDelete == 'N' }">
								<tr id=`board${board.no }` class="board" onclick="location.href='viewBoard.bo?no=${board.no}';">
									<td>${board.no }</td>
									<td>${board.title }</td>
									<td>${board.writer }</td>
									<td class="postDate">${board.postDate }</td>
									<td>${board.readcount }</td>
									<td>${board.likecount }</td>
								</tr>
								</c:when>
								<c:otherwise>
									<tr id=`board${board.no }` class="board delBoard"">
									<td>${board.no }</td>
									<td>${board.title }</td>
									<td>${board.writer }</td>
									<td class="postDate">${board.postDate }</td>
									<td>${board.readcount }</td>
									<td>${board.likecount }</td>
								</tr>
								</c:otherwise>
							</c:choose>
								
							</c:forEach>
						</tbody>
					</table>
				</c:when>
				<c:otherwise>
					텅
				</c:otherwise>
			</c:choose>
		</div>
		<div class="btns">
			<button type="button" class="btn btn-primary"
				onclick="location.href='writeBoard.jsp';">글쓰기</button>
		</div>
	</div>
	<jsp:include page="../footer.jsp"></jsp:include>
</body>
</html>