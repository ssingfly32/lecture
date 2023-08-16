package com.ksh.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.ksh.vo.DeptVO;
import com.ksh.vo.JobsVO;
import com.ksh.vo.ManagerVO;

public class GetInfo {
	private static GetInfo instance = null;

	private GetInfo() {
	}

	public static GetInfo getInstance() {
		if (instance == null) {
			instance = new GetInfo();
		}

		return instance;
	}

	public List<JobsVO> getJobsInfo() throws NamingException, SQLException {

		List<JobsVO> lst = new ArrayList<JobsVO>();

		Connection con = DBConnection.getInstance().dbConnect();

		String query = "select * from jobs";

		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			lst.add(new JobsVO(rs.getString("JOB_ID"), rs.getString("JOB_TITLE"), rs.getInt("MIN_SALARY"),
					rs.getInt("MAX_SALARY")));

		}
		DBConnection.getInstance().dbClose(rs, pstmt, con);

		return lst;
	}

	public List<ManagerVO> getManagerInfo() throws NamingException, SQLException {
		
		List<ManagerVO> lst = new ArrayList<ManagerVO>();

		Connection con = DBConnection.getInstance().dbConnect();

		String query = "select first_name||','||last_name as fullName, employee_id " 
				+ "from employees";

		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			lst.add(new ManagerVO(
					rs.getString("fullName"), 
					rs.getInt("employee_id")));
		}
		
		DBConnection.getInstance().dbClose(rs, pstmt, con);

		return lst;
	}

	public List<DeptVO> getDeptInfo() throws NamingException, SQLException {
		List<DeptVO> lst = new ArrayList<DeptVO>();

		Connection con = DBConnection.getInstance().dbConnect();

		String query = "select department_id, department_name "
				+ "from departments";

		PreparedStatement pstmt = con.prepareStatement(query);
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			lst.add(new DeptVO(
					rs.getInt("department_id"), 
					rs.getString("department_name")));
		}
		
		DBConnection.getInstance().dbClose(rs, pstmt, con);

		return lst;
	}
}

