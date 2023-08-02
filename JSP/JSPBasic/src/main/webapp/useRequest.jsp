<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다양한 input 태그들의 request 처리</title>
</head>
<body>
	<form action="./useRequest.do" method="post">
		<div>
			아이디 : <input type="text" name="userId"></div>
		<div>
			비밀번호 : <input type="password" name="userPwd"></div>
		<div>
			이름 : <input type="text" name="userName">
		</div>
		<div>
			성별 : <label><input type="radio" name="gender" value="female">여성</label> <label><input
				type="radio" name="gender" value="male">남성</label>
		</div>
		<div>
			군필 : <label><input type="radio" name="military" value="unfilled">미필</label> 
			<label><input type="radio" name="military" value="fulfilled">만기전역</label>
		</div>
		<div>취미
			<label><input type="checkbox" name="hobby" value="programming" checked>프로그래밍</label>
			<label><input type="checkbox" name="hobby" value="netflix">넷플릭스</label>
			<label><input type="checkbox" name="hobby" value="sleeping">낮잠</label>
			<label><input type="checkbox" name="hobby" value="drinking">술마시기</label>
		</div>
		<div>직업
			<select name="job">
				<option value="student">학생</option>
				<option value="programmer">프로그래머</option>
				<option value="public officer">공무원</option>
				<option value="self employees">자영업</option>
			</select>
		</div>
		
		<div>
			생일 <input type="date" name="birth"> 
		</div>
		
		<div>
			<textarea rows="10" cols="20" name="memo"></textarea>
		</div>
		
		<div>
			<input type="submit" value="전송">
		</div>
	</form>
	<hr/>
	<div>${userInfo}</div>
</body>
</html>