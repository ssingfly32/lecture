<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>다양한 input 태그들의 request 처리</title>
<script>
	function isvalid() {
		let result = false;
		
		let name = '홍길동';
		document.write(`\${name}안녕`); //jsp에서 temperture literal 사용법.
		document.write(name+'안녕');
		
		// 생일이 입력 되었다면 true(생일 필수 항목)
		let birth = document.getElementById('birth').value;
		if(birth.length > 0) {
			result = true;
		} else {
			alert('생일은 반드시 입력해야 합니다.');
			// 뷰단에서 유효성 검사했기때문에 작성한 텍스트 그대로 남아있음.
		}
		
		return result;
	}
</script>
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
			생일 <input type="date" name="birth" id="birth"> 
		</div>
		
		<div>
			<textarea rows="10" cols="20" name="memo"></textarea>
		</div>
		
		<div>
			<input type="submit" value="전송" onclick="return isvalid();">
		</div>
	</form>
	<hr/>
	<div>${userInfo}</div>
</body>
</html>