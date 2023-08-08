<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<title>index.jsp</title>
<script>
	$(document).ready(function() {
		getEmployees();
		
		$('#findEmpName').keyup(function(e) {
			if (e.keyCode == 13) { // 엔터가 눌러졌다면
				if ($(this).val().length > 1) {
					let findEmpName = $(this).val();
					
					$.ajax({
						url : './findEmpByName.do', // 데이터를 수신받을 서버 주소
						type : 'post', // 통신방식(GET, POST, PUT, DELETE)
						data : {
							"empName" : findEmpName
						},
						dataType : 'json',
						async : false, // 데이터가 오면 실행해야해서
						success : function(data) {
							console.log(data);
							if(data.responseCode == "00") {
								outputEmployees(data);
								}
						},
						error : function() {
						}, // 통신이 실패(부정적인 response) 했을 때 호출되는 콜백함수
						complete : function() {
						}, // 통신이 완료 되었을때 호출 되는 콜백함수
					});
				}	
			}
		});
		$('#findEmpNo').keyup(function(e) {
			if (e.keyCode == 13) { // 엔터가 눌러졌다면
				if ($(this).val().length > 1) {
					let findEmpNo = $(this).val();
					
					$.ajax({
						url : './findEmpByNo.do', // 데이터를 수신받을 서버 주소
						type : 'post', // 통신방식(GET, POST, PUT, DELETE)
						data : {
							"empNo" : findEmpNo
						},
						dataType : 'json',
						async : false, // 데이터가 오면 실행해야해서
						success : function(data) {
							console.log(data);
							if(data.responseCode == "00") {
								outputEmployees(data);
								} else if(data.responseCode == "04") {
									alert(data.responseMsg);
								}
						},
						error : function() {
						}, // 통신이 실패(부정적인 response) 했을 때 호출되는 콜백함수
						complete : function() {
						}, // 통신이 완료 되었을때 호출 되는 콜백함수
					});
				}	
			}
		});
	});

	function getEmployees() {
		$.ajax({
			url : './getEmp.do', // 데이터를 수신받을 서버 주소
			type : 'get', // 통신방식(GET, POST, PUT, DELETE)
			dataType : 'json',
			async : false, // 데이터가 오면 실행해야해서
			success : function(data) {
				console.log(data);
				if(data.responseCode == "00") {
				outputEmployees(data);
				} else if (data.count == "0" && data.count == "0") {
					alert("조회할 데이터가 없습니다. (직원 없음)");
				} else if (data.responseCode != "00") {
					alert("데이터를 가져오지 못했습니다");
				}
			},
			error : function() {
			}, // 통신이 실패(부정적인 response) 했을 때 호출되는 콜백함수
			complete : function() {
			}, // 통신이 완료 되었을때 호출 되는 콜백함수
		});
	}

	function outputEmployees(json) {
		let output = ' <table class="table table-hover">';
		output += ' <thead><tr><th>사번</th><th>이름</th><th>이메일</th><th>전화번호</th><th>입사일</th>';
		output += '<th>직무</th><th>급여</th><th>커미션</th><th>사수</th><th>부서명</th>';
		output += '</tr></thead><tbody>';
		$.each(json.employees, function(i, e) {
			output += `<tr><td>\${e.employee_id}</td>`; // 자바에선 실행안되고 js에선 실행됨 (역슬러시)
			output += `<td>\${e.first_name},\${e.last_name}</td>`;
			output += `<td>\${e.email}</td>`;
			output += `<td>\${e.phone_number}</td>`;
			output += `<td>\${e.hire_date}</td>`;
			output += `<td>\${e.job_id}</td>`;

			// 급여를 소수점 이하가 없다면 나오지 않도록 처리
			let sal = 0;
			if (e.salary.split('.')[1] === '0') {
				sal = Number(e.salary.split('.')[0]);
			} else {
				sal = Number(e.salary);
			}
			// 급여를 3자리수마다 콤마, $ 기호 붙여서
			sal = sal.toLocaleString();
			output += `<td>$\${sal}</td>`;
			// 커미션을 %단위로 바꾸어 출력
			let comm = Number(e.commission_pct) * 100;
			output += `<td>\${comm}%</td>`;

			// 사수를 출력하되 사수의 사번으로 사수의 이름을 찾아 출력하자
			let managerName = findManagerName(e.manager_id, json.employees);
			output += `<td>\${managerName}</td>`;
			// output += `<td>\${e.department_id}</td>`;  
			output += `<td>\${e.department_name}</td>`;
			output += `</tr>`;
		});

		output += `</tbody></table>`;
		$('.employees').html(output);
	}

	function findManagerName(managerId, empList) {
		let managerName = '';
		$.each(empList, function(i, e) {
			if (e.employee_id == managerId) { // 찾았다
				managerName = e.first_name;
			}
		});
		return managerName;
	}
</script>
<style>
.employees {
	font-size: 0.8em;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Employees With Ajax</h1>
		<div class="searchEmp">
			<div class="mb-3 mt-3">
				<label for="findEmpName" class="form-label">찾을 사원 이름 : </label> <input
					type="text" class="form-control" id="findEmpName"
					placeholder="찾을 사원 이름 입력..." />
				<label for="findEmpNo" class="form-label">찾을 사원 사번 : </label> <input
					type="text" class="form-control" id="findEmpNo"
					placeholder="찾을 사원 사번 입력..." />
			</div>
		</div>
		<div class="employees"></div>
	</div>

</body>
</html>