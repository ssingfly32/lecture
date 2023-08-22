<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div class="container">
		<h1>게시판 전체 목록 조회</h1>
		<div class="boardList">
			<c:choose>
				<c:when test="${boardList != null}">
					<table class="table tavle-hover">
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
								<tr>
									<td>${board.no }</td>
									<td>${board.title }</td>
									<td>${board.writer }</td>
									<td>${board.postDate }</td>
									<td>${board.readcount }</td>
									<td>${board.likecount }</td>
								</tr>
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