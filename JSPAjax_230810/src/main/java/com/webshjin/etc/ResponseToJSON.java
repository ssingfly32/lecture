package com.webshjin.etc;

import java.sql.Date;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.webshjin.vo.Employee;

public class ResponseToJSON {
	
	
	public String makeJsonWithSimpleJson(List<Employee> empList) {
		JSONObject json = new JSONObject();
		JSONArray employees = new JSONArray();
		
		for (Employee e : empList) {
			JSONObject employee = new JSONObject();
			employee.put("employee_id", e.getEmployee_id() + "");
			employee.put("first_name", e.getFirst_name());
			employee.put("last_name", e.getLast_name());
			employee.put("email", e.getEmail());
			employee.put("phone_number", e.getPhone_number());
			employee.put("hire_date", e.getHire_date().toString());
			employee.put("job_id", e.getJob_id());
			employee.put("salary", e.getSalary() + "");
			employee.put("commission_pct", e.getCommission_pct() + "");
			employee.put("manager_id", e.getManager_id() + "");
			employee.put("department_id", e.getDepartment_id());
			employee.put("department_name", e.getDepartment_name());
			
			employees.add(employee);
		}
		
		json.put("employees", employees);
		json.put("createdTime", new Date(System.currentTimeMillis()).toLocaleString());
		json.put("count", empList.size() + "");
		json.put("responseCode", "00");
		json.put("responseMsg", ResponseMessageCode.getMessage("00"));
		
		return json.toJSONString();
	}

}
