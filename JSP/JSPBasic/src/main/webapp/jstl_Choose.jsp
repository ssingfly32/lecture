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
	<form action="jstl_Choose_sub.jsp">
		<label> 좋아하는 계절
			<select name="favSeason">
				<option value="spring">봄</option>
				<option value="summer">여름</option>
				<option value="autumn">가을</option>
				<option value="winter">겨울</option>
			</select>
		</label>
		
		<input type="submit" value="전송" />
	</form>
</body>
</html>