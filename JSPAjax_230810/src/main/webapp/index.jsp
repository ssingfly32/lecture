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
	let EmpData = null;

	function inputEmpValidate(tmpEmp) {
		let isLastNameValid = lastNameValid(tmpEmp.lastName);
		let isEmailValid = emailValid(tmpEmp.email);
		let isHireDateValid = hireDateValid(tmpEmp.hireDate);
		let isJobIdValid = jobIdValid(tmpEmp.jobId);
		let isManagerId = managerIdValid(tmpEmp.managerId);
		let isDepartmentId = departmentIdValid(tmpEmp.departmentId);

		if (isLastNameValid && isEmailValid && isHireDateValid && isJobIdValid
				&& isManagerId && isDepartmentId) {
			// 모든 유효성에 통과 되었다
			console.log(tmpEmp);

			$.ajax({
				url : './saveEmp.do', // 데이터를 수신받을 서버 주소
				type : 'post', // 통신방식(GET, POST, PUT, DELETE)
				data : tmpEmp,
				dataType : 'json',
				async : false,
				success : function(data) {
					console.log(data);
					if (data.responseMsg == 'OK') {
						alert('사원이 잘 저장되었습니다');
					} else {
						alert('사원 저장 실패');
						console.log(data.exceptionMsg);
					}
					initInputModal();
					$('#saveEmpModal').hide();
					getEmployees(); // 데이터 새로고침
				}
			});
		}
	}

	function departmentIdValid(departmentId) {
		// 부서 - fk 제약조건 
		let isDepartmentId = true;
		if (departmentId === '부서를 선택하세요') {
			printErrMsg('iDepartmentID', '부서를 선택하세요');
			isDepartmentId = false;
		}
		return isDepartmentId;
	}

	function managerIdValid(managerid) {
		// 상사 - fk 제약조건 
		let isManagerId = true;
		if (managerid === '상사를 선택하세요') {
			printErrMsg('iManagerId', '상사를 선택하세요');
			isManagerId = false;
		}
		return isManagerId;
	}

	function jobIdValid(jobid) {
		// 직무 - fk 제약조건 
		let isJobIdValid = true;
		if (jobid === '직무를선택하세요') {
			printErrMsg('iJobId', '직무를 선택하세요');
			isJobIdValid = false;
		}
		return isJobIdValid;
	}

	function hireDateValid(hiredate) {
		// 입사일 - not null
		let isHireDateValid = true;
		if (hiredate.length < 1) {
			printErrMsg('iHireDate', '입사일을 기입하세요');
			isHireDateValid = false;
		}

		return isHireDateValid;
	}

	function emailValid(email) {

		// email - not null && unique
		let isEmailNNValid = true;
		let isEmailUQValid = true;
		if (email.length < 1) {
			// 에러메시지 출력
			printErrMsg('iEmail', 'Email은 필수항목입니다');
			isEmailNNValid = false;
		}

		$.each(EmpData.employees, function(i, e) {
			if (email == e.email) {
				isEmailUQValid = false;
				printErrMsg('iEmail', 'Email이 중복되면 안되요오오');
			}
		});

		if (isEmailNNValid && isEmailUQValid) {
			return true;

		} else {
			return false;
		}
	}

	function lastNameValid(lastname) {
		// lastName - not null
		isLastNameValid = true;
		if (lastname.length < 1) {
			// 에러메시지 출력
			printErrMsg('iLastName', 'lastName은 필수항목입니다');
			isLastNameValid = false;
		}
		return isLastNameValid;
	}

	function printErrMsg(id, msg) {
		let errMsg = `<div class='errMsg'>\${msg}</div>`;
		$(errMsg).insertAfter($(`#\${id}`));
		$(`#\${id}`).focus();
		$('.errMsg').hide(3000);
	}

	function initInputModal() {
		$('#iFirstName').val('');
		$('#iLastName').val('');
		$('#iEmail').val('');
		$('#iPhoneNumber').val('');
		$('#iHireDate').val('');
		document.getElementById('iJobId').selectedIndex = 0;
		$('#iSalary').val('');
		$('#iComm').val('0');
		document.getElementById('iManagerId').selectedIndex = 0;
		document.getElementById('iDepartmentID').selectedIndex = 0;
	}

	$(document).ready(function() {
		getEmployees();

		// 사원 삭제 모달창 닫기 버튼 클릭시
		$('.delEmpModalClose').click(function(){
			$('#delEmpModal').hide();
		});
		
		// 사원 삭제 버튼 클릭시
		$('.delEmpBtn').click(function () {
			let delEmpNo = $('#delEmpNo').html();
			
			$.ajax({
				url : './delEmp.do', // 데이터를 수신받을 서버 주소
				type : 'post', // 통신방식(GET, POST, PUT, DELETE)
				data : {
					"delEmpNo" : delEmpNo
				},
				dataType : 'json',
				async : false,
				success : function(data) {
					console.log(data);
					if(data.responseMsg == 'OK') {
						alert('사원 삭제 성공');
						getEmployees();
						$('#delEmpModal').hide();
					} else {
						alert('사원 삭제 실패');
					}
				}
			});
			
		});
		
		// 사원저장 버튼 클릭시
		$('.inputEmpBtn').click(function() {
			let firstName = $('#iFirstName').val();
			let lastName = $('#iLastName').val();
			let email = $('#iEmail').val().toUpperCase();
			let phoneNumber = $('#iPhoneNumber').val();
			let hireDate = $('#iHireDate').val();
			let jobId = $('#iJobId').val();
			let salary = $('#iSalary').val();
			let comm = Number($('#iComm').val()) / 100;
			let managerId = $('#iManagerId').val();
			let departmentId = $('#iDepartmentID').val();

			let tmpEmp = {
				"firstName" : firstName,
				"lastName" : lastName,
				"email" : email,
				"phoneNumber" : phoneNumber,
				"hireDate" : hireDate,
				"jobId" : jobId,
				"salary" : salary,
				"comm" : comm,
				"managerId" : managerId,
				"departmentId" : departmentId
			};

			inputEmpValidate(tmpEmp);

		});

		$('#iJobId').change(function() {
			console.log($(this).val());
			if ($(this).val() != '직무를선택하세요') {
				makeRange($(this).val());
			}
		});

		$('#iSalary').change(function() {
			let tmpSal = Number($(this).val()).toLocaleString();

			$('#selectedSal').html(`$\${tmpSal}`);
		});

		// 사원 저장 모달창 닫기
		$(".inputModalClose").click(function() {
			initInputModal();

			$("#saveEmpModal").hide();
		});

		$('.orderMethod').click(function() {
			let orderMethod = $(this).val();

			$.ajax({
				url : './orderByEmp.do', // 데이터를 수신받을 서버 주소
				type : 'post', // 통신방식(GET, POST, PUT, DELETE)
				data : {
					"orderMethod" : orderMethod
				},
				dataType : 'json',
				async : false,
				success : function(data) {
					console.log(data);
					if (data.responseCode == "00") {
						outputEmployees(data);
					}
				}
			});
		});

		$('#findEmpName').keyup(function(e) {
			if (e.keyCode == 13) { // 엔터가 눌려졌다면
				if ($(this).val().length > 1) { // 2글자 이상 이면
					let findEmpName = $(this).val();

					$.ajax({
						url : './findEmpByName.do', // 데이터를 수신받을 서버 주소
						type : 'post', // 통신방식(GET, POST, PUT, DELETE)
						data : {
							"empName" : findEmpName
						},
						dataType : 'json',
						async : false,
						success : function(data) {
							console.log(data);
							if (data.responseCode == "00") {
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
	});

	function getEmployees() {
		$.ajax({
			url : './getEmp.do', // 데이터를 수신받을 서버 주소
			type : 'get', // 통신방식(GET, POST, PUT, DELETE)
			dataType : 'json',
			async : false,
			success : function(data) {
				console.log(data);
				EmpData = data;
				if (data.responseCode == "00") {
					outputEmployees(data);
				} else if (data.responseCode == "00" && data.count == "0") {
					alert("회사 망했어요~");
				} else if (data.responseCode != "00") {
					alert("데이터를 가져오지 못했습니다")
				}
			},
			error : function() {
			}, // 통신이 실패(부정적인 response) 했을 때 호출되는 콜백함수
			complete : function() {
			}, // 통신이 완료 되었을때 호출 되는 콜백함수
		});
	}

	function outputEmployees(json) {
		let output = '<table class="table table-hover">';
		output += '<thead><tr><th>사번</th><th>이름</th><th>이메일</th><th>전화번호</th><th>입사일</th>';
		output += '<th>직무</th><th>급여</th><th>커미션</th><th>사수</th><th>부서명</th><th>수정</th><th>삭제</th>';
		output += '</tr></thead><tbody>';
		$
				.each(
						json.employees,
						function(i, e) {
							output += `<tr><td>\${e.employee_id}</td>`;
							output += `<td>\${e.first_name}, \${e.last_name}</td>`;
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
							let managerName = findManagerName(e.manager_id,
									json.employees);
							output += `<td>\${managerName}</td>`;

							// output += `<td>\${e.department_id}</td>`;
							output += `<td>\${e.department_name}</td>`;
							output += `<td><img src='./image/modify.png' class='icon' /></td>`;
							output += `<td><img src='./image/delete.png' class='icon' onclick='delEmp(\${e.employee_id});' /></td>`;
							output += `</tr>`;
						});

		output += `</tbody></table>`;
		$('.employees').html(output);
	}

	function delEmp(empNo) {
		//alert(empNo + "번 사원을 삭제하자!");
		$("#delEmpNo").html(empNo);
		$('#delEmpModal').show(500);
	}

	function findManagerName(managerId, empList) {
		let managerName = '';
		$.each(empList, function(i, e) {
			if (e.employee_id === managerId) { // 찾았다
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

		// department select만들기
		makeSelectDepartment();

		$("#saveEmpModal").show(500);
	}

	function makeSelectDepartment() {
		$
				.ajax({
					url : './getDeptInfo.do',
					type : 'get',
					dataType : 'json',
					async : false,
					success : function(data) {
						console.log(data);
						let output = "<option>부서를 선택하세요</option>";
						$
								.each(
										data,
										function(i, elt) {
											output += `<option value='\${elt.department_id}'>\${elt.department_name}</option>`;
										});

						$('#iDepartmentID').html(output);
					}
				})
	}

	function makeSelectManagerId() {
		$
				.ajax({
					url : './getManagerInfo.do',
					type : 'get',
					dataType : 'json',
					async : false,
					success : function(data) {
						console.log(data);
						let output = "<option>상사를 선택하세요</option>";
						$
								.each(
										data,
										function(i, elt) {
											output += `<option value='\${elt.employee_id}'>\${elt.fullName}</option>`;
										});

						$('#iManagerId').html(output);
					}
				});
	}

	function makeRange(selectedJob) {
		let minSal = 0, maxSal = 0;
		$.each(JobsInfo, function(i, e) {
			if (e.job_id === selectedJob) {
				minSal = e.min_salary;
				maxSal = e.max_salary;
			}
		});

		$('#iSalary').attr('max', maxSal);
		$('#iSalary').attr('min', minSal);
		$('#iSalary').attr('step', 10);
	}

	function makeSelectJobId() {
		$
				.ajax({
					url : './getJobsInfo.do',
					type : 'get',
					dataType : 'json',
					async : false,
					success : function(data) {
						console.log(data);
						JobsInfo = data;
						let output = "<option>직무를선택하세요</option>";
						$
								.each(
										data,
										function(i, e) {
											output += `<option value='\${e.job_id}'>\${e.job_title}</option>`;
										});

						$('#iJobId').html(output);
					}
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
	bottom: 20px;
	right: 20px;
	width: 50px;
	height: 50px;
	border-radius: 25px;
}

#selectedSal {
	color: orange;
}

.errMsg {
	color: red;
	font-weight: bold;
	font-size
	=
	15px;
}

.icon {
	width: 20px;
	height: 20px;
}
</style>
</head>
<body>
	<div class="container">
		<h1>Employees With Ajax</h1>

		<div class="searchEmp">
			<div class="byName">
				<div class="mb-3 mt-3">
					<label for="findEmpName" class="form-label">찾을 사원 이름 :</label> <input
						type="text" class="form-control" id="findEmpName"
						placeholder="찾을 사원 이름 입력...." />
				</div>
			</div>
			<div class="sortEmp">
				<div class="order">
					<label for="orderEmpNo" class="form-label">사번순(오름차순)</label> <input
						type="radio" id="orderEmpNo" class="orderMethod"
						name="orderMethod" value="empNo" checked />
				</div>
				<div class="order">
					<label for="orderHiredate" class="form-label">입사일(내림차순)</label> <input
						type="radio" id="orderHiredate" class="orderMethod"
						name="orderMethod" value="hiredate" />
				</div>
				<div class="order">
					<label for="orderSal" class="form-label">급여순(내림차순)</label> <input
						type="radio" id="orderSal" class="orderMethod" name="orderMethod"
						value="salary" />
				</div>
			</div>
		</div>

		<div class="employees"></div>

	</div>

	<div class="saveEmpIcon">
		<img src="./image/writing.png" onclick="inputModalOpen();" />
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
							type="text" class="form-control" id="iFirstName" />
					</div>
					<div class="mb-3 mt-3">
						<label for="iLastName" class="form-label">lastName:</label> <input
							type="text" class="form-control" id="iLastName" />
					</div>
					<div class="mb-3 mt-3">
						<label for="iEmail" class="form-label">Email:</label> <input
							type="text" class="form-control" id="iEmail" />
					</div>
					<div class="mb-3 mt-3">
						<label for="iPhoneNumber" class="form-label">PhoneNumber:</label>
						<input type="text" class="form-control" id="iPhoneNumber" />
					</div>
					<div class="mb-3 mt-3">
						<label for="iHireDate" class="form-label">HireDate:</label> <input
							type="date" class="form-control" id="iHireDate" />
					</div>
					<div class="mb-3 mt-3">
						<label for="iJobId" class="form-label">JobId:</label> <select
							class="form-select" id="iJobId">
						</select>
					</div>
					<div class="mb-3 mt-3">
						<label for="iSalary" class="form-label">Salary: <span
							id='selectedSal'></span></label> <input type="range" class="form-range"
							id="iSalary">
					</div>
					<div class="mb-3 mt-3">
						<label for="iComm" class="form-label">CommissionPct:</label> <input
							type="number" class="form-range" id="iComm" max="100" min="0">
					</div>
					<div class="mb-3 mt-3">
						<label for="iManagerId" class="form-label">ManagerId:</label> <select
							class="form-select" id="iManagerId">
						</select>
					</div>
					<div class="mb-3 mt-3">
						<label for="iDepartmentID" class="form-label">DepartmentID:</label>
						<select class="form-select" id="iDepartmentID">
						</select>
					</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger inputModalClose"
						data-bs-dismiss="inputEmpModal">Close</button>
					<button type="button" class="btn btn-success inputEmpBtn">Save</button>
				</div>

			</div>
		</div>
	</div>

	<!-- The 삭제 Modal -->
	<div class="modal" id="delEmpModal">
		<div class="modal-dialog">
			<div class="modal-content">

				<!-- Modal Header -->
				<div class="modal-header">
					<h4 class="modal-title">사원 삭제</h4>
					<button type="button" class="btn-close delEmpModalClose" data-bs-dismiss="modal"></button>
				</div>

				<!-- Modal body -->
				<div class="modal-body">
					<span id="delEmpNo"></span>번 사원을 삭제 할까요?
					<div>한번 삭제된 사원은 복구 할 수 없습니다.</div>
				</div>

				<!-- Modal footer -->
				<div class="modal-footer">
					<button type="button" class="btn btn-danger delEmpModalClose"
						data-bs-dismiss="modal">취소</button>
					<button type="button" class="btn btn-success delEmpBtn">삭제</button>
				</div>

			</div>
		</div>
	</div>

</body>
</html>