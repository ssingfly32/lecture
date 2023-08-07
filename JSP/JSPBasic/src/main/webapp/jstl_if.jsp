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
<!-- 겟방식으로 요청했기때문에 쿼리스트링 잘 넘어감 -->
	<form action="jstl_if_sub.jsp">
		<label> 좋아하는 노래
			<select name="favSong">
				<option value="ditto">Ditto</option>
				<option value="seven">Seven</option>
				<option value="oldSong">아리랑</option>
			</select>
		</label>
		
		<input type="submit" value="전송" />
	</form>
</body>
</html>