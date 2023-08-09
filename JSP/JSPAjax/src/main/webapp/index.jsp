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
	let JobsInfo = null;

	
	$(document).ready(function() {
		getEmployees();
		$('#iJobId').change(function() {
			console.log($(this).val());
			if($(this).val() != '직무를 선택하세요') {
				makeRange($(this).val());
			}
		});
		$('#iSalary').change(function() {
			let tmpSal = Number($(this).val()).toLocaleString();
			$('#selectedSal').html(`$\${tmpSal}`);
		})	;
		$('.inputModalClose').click(function() {
			$('#saveEmpModal').hide();
		});
		$('.orderMethod').click(function() {
			let orderMethod = ($(this).val());

			$.ajax({
				url : './orderByEmp.do', // 데이터를 수신받을 서버 주소
				type : 'post', // 통신방식(GET, POST, PUT, DELETE)
				data : {
					"orderMethod" : orderMethod
				},
				dataType : 'json',
				async : false, // 데이터가 오면 실행해야해서
				success : function(data) {
					console.log(data);
					if (data.responseCode == "00") {
						outputEmployees(data);
					}
				},
			});
		});
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
							if (data.responseCode == "00") {
								outputEmployees(data);
								if (data.responseCode == "00" && data.count == "0") {
									alert("조회할 데이터가 없습니다. (직원 없음)");
								}
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
							if (data.responseCode == "00") {
								outputEmployees(data);
							} else if (data.responseCode == "04") {
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
				if (data.responseCode == "00") {
					outputEmployees(data);
				} else if (data.responseCode == "00" && data.count == "0") {
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

	function inputModalOpen() {
		// jobid select 만들기
		makeSelectJobId();
		
		// manager select 만들기
		makeSelectManagerId();
		
		makeSelectDepartment();
	
		$("#saveEmpModal").show(500);
	}
	
	function makeSelectDepartment() {
		$.ajax({
			url : './getDepartmentInfo.do', 
			type : 'get', // 통신방식(GET, POST, PUT, DELETE)
			dataType : 'json',
			async : false, // 데이터가 오면 실행해야해서
			success : function(data) {
				console.log(data);
				let output = "<option>부서를 선택하세요</option>";
				$.each(data, function(i, e) {
					output += `<option value='\${e.department_id}'>\${e.department_name}</option>`;
				});
				$('#iDepartmentId').html(output);
			},
		});
	}
	function makeSelectManagerId() {
		$.ajax({
			url : './getManagerInfo.do', 
			type : 'get', // 통신방식(GET, POST, PUT, DELETE)
			dataType : 'json',
			async : false, // 데이터가 오면 실행해야해서
			success : function(data) {
				console.log(data);
				let output = "<option>상사를 선택하세요</option>";
				$.each(data, function(i, e) {
					output += `<option value='\${e.employee_id}'>\${e.fullName}</option>`;
				});
				$('#iManagerId').html(output);
			},
		});
	}
	function makeRange(selectedJob) {
		let minSal = 0, maxSal = 0;
		$.each(JobsInfo, function(i, e) {
			if(e.job_id == selectedJob) {
				minSal = e.min_salary;
				maxSal = e.max_salary;
			}
		});
		$('#iSalary').attr('max', maxSal);
		$('#iSalary').attr('min', minSal);
		$('#iSalary').attr('step', 100);
	}
	
	function makeSelectJobId() {
		$.ajax({
			url : './getJobsInfo.do', // 데이터를 수신받을 서버 주소
			type : 'get', // 통신방식(GET, POST, PUT, DELETE)
			dataType : 'json',
			async : false, // 데이터가 오면 실행해야해서
			success : function(data) {
				console.log(data);
				JobsInfo = data;
				let output = "<option>직무를 선택하세요</option>";
				$.each(data, function(i, e) {
					output += `<option value='\${e.job_id}'>\${e.job_title}</option>`;
				});
				$('#iJobId').html(output);
			},
		});
	}
</script>
<style>
.employees {
	font-size: 0.8em;
}

.sortEmp {
	display: flex;
	justify-content: space-between;
}

.saveEmpIcon img {
	position: fixed;
	bottom: 10px;
	right: 10px;
	width: 50px;
	height: 50px;
	border-radius: 25px;
}

#selectedSal {
	color : orange;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Employees With Ajax</h1>
		<div class="searchEmp">
			<div class="byName">
				<div class="mb-3 mt-3">
					<label for="findEmpName" class="form-label">찾을 사원 이름 : </label> <input
						type="text" class="form-control" id="findEmpName"
						placeholder="찾을 사원 이름 입력..." /> <label for="findEmpNo"
						class="form-label">찾을 사원 사번 : </label> <input type="text"
						class="form-control" id="findEmpNo" placeholder="찾을 사원 사번 입력..." />
				</div>
			</div>
			<div class="sortEmp">
				<div class="order">
					<label for="orderEmpNo" class="form-label">사번순 (오름차순) : </label> <input
						type="radio" id="orderEmpNo" class="orderMethod"
						name="orderMethod" value="empNo" checked="checked" />
				</div>
				<div class="order">
					<label for="orderHiredate" class="form-label">입사일 (오름차순) :
					</label> <input type="radio" id="orderHiredate" class="orderMethod"
						name="orderMethod" value="hiredate" />
				</div>
				<div class="order">
					<label for="orderSal" class="form-label">급여순(오름차순) : </label> <input
						type="radio" id="orderSal" class="orderMethod" name="orderMethod"
						value="salary" />
				</div>

			</div>
		</div>

		<div class="employees"></div>
	</div>
	<div class="saveEmpIcon">
		<img src="./image/contract.png" onclick="inputModalOpen();" />
	</div>
	<!-- The Modal -->
	<div class="modal inputEmpModal" id="saveEmpModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">사원 저장</h4>
					<button type="button" class="btn-close inputModalClose"
						data-bs-dismiss="inputEmpModal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<div class="mb-3 mt-3">
						<label for="iFirstName" class="form-label">firstName:</label> <input
							type="text" class="form-control" id="iFirstName">
					</div>
					<div class="mb-3 mt-3">
						<label for="iLastName" class="form-label">lastName:</label> <input
							type="text" class="form-control" id="iLastName">
					</div>
					<div class="mb-3 mt-3">
						<label for="iEmail" class="form-label">Email:</label> <input
							type="text" class="form-control" id="iEmail">
					</div>
					<div class="mb-3 mt-3">
						<label for="iPhoneNumber" class="form-label">PhoneNumber:</label>
						<input type="text" class="form-control" id="iPhoneNumber">
					</div>
					<div class="mb-3 mt-3">
						<label for="iHiredate" class="form-label">HireDate:</label> <input
							type="date" class="form-control" id="iHiredate">
					</div>
					<div class="mb-3 mt-3">
				<label for="iJobId" class="form-label">JobId:</label>
						<select class="form-select" id="iJobId">
						</select>
					</div>
					
	
			
				<div class="mb-3 mt-3">
					<label for="iSalary" class="form-label">Salary: <span id='selectedSal'></span></label> <input
						type="range" class="form-range" id="iSalary">
				</div>
				<div class="mb-3 mt-3">
					<label for="iComm" class="form-label">CommissionPct: </label> <input
						type="number" class="form-range" id="iComm" max="100" min="0">
				</div>
				<div class="mb-3 mt-3">
				<label for="iManagerId" class="form-label">ManagerId:</label>
						<select class="form-select" id="iManagerId">
						</select>
					</div>
					<div class="mb-3 mt-3">
				<label for="iDepartmentId" class="form-label">DepartmentId:</label>
						<select class="form-select" id="iDepartmentId">
						</select>
					</div>
					</div>
				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger inputModalClose"
						data-bs-dismiss="inputEmpModal">Close</button>
						<button type="button" class="btn btn-success inputEmpBtn">save</button>
				</div>

			</div>
		</div>
	</div>


</body>
</html>