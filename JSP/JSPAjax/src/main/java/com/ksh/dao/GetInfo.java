package com.ksh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.ksh.vo.DepartmentVo;
import com.ksh.vo.JobsVo;
import com.ksh.vo.ManagerVo;

public class GetInfo {
private static GetInfo instance = null;
	
	private GetInfo() {}
	
	public static GetInfo getInstance() {
		if (instance == null) {
			instance = new GetInfo();
		}
		return instance;
	}
	
	public List<JobsVo> getJobsInfo() throws NamingException, SQLException {
		List<JobsVo> lst = new ArrayList<JobsVo>();
		Connection con = DBConnection.getInstance().dbConnect();
		
		String query = "select * from jobs";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			lst.add(new JobsVo(rs.getString("JOB_ID"),
					rs.getString("JOB_TITLE") , 
					rs.getInt("MIN_SALARY"), 
					rs.getInt("MAX_SALARY")));
		}
		DBConnection.getInstance().dbClose(rs, pstmt, con);
		
		return lst;
	}

	public List<ManagerVo> getManagerInfo() throws NamingException, SQLException {
		
		List<ManagerVo> lst = new ArrayList<ManagerVo>();
		
		Connection con = DBConnection.getInstance().dbConnect();
		
		String query = "select first_name||','||last_name as fullName, employee_id "
				+ "from employees";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			lst.add(new ManagerVo(rs.getString("fullName"),
					 rs.getInt("employee_id")));
		}
		DBConnection.getInstance().dbClose(rs, pstmt, con);
		
		return lst;
		
	}

	public List<DepartmentVo> getDepartmentInfo() throws NamingException, SQLException {
		List<DepartmentVo> lst = new ArrayList<DepartmentVo>();
		Connection con = DBConnection.getInstance().dbConnect();
		
		String query = "select department_id, department_name "
				+ "from departments";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			lst.add(new DepartmentVo(rs.getInt("department_id"), rs.getString("department_name")));
		}
		DBConnection.getInstance().dbClose(rs, pstmt, con);
		
		return lst;
	}
}
