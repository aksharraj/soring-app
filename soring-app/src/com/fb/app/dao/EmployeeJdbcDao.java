package com.fb.app.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Repository;

import com.fb.app.bean.Employee;
import com.fb.app.bean.EmployeeListVO;

@Repository
public class EmployeeJdbcDao {
	
	private Connection getConnection() throws Exception{
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost/hr?autoReconnect=true&useSSL=false", "hr", "hr");
		return c;
	}

	/*static EmployeeListVO list = new EmployeeListVO();
	static {
		Employee one = new Employee("1","Raj","Gupta");
		Employee two = new Employee("1","Raja","Gupta");
		
		list.getEmployees().add(one);
		list.getEmployees().add(two);
	}*/
	
	
	
	public EmployeeListVO getAllEmployees() {
		EmployeeListVO employees = new EmployeeListVO();
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement pstmt = c.prepareStatement("SELECT * FROM Employee");
			ResultSet rs = pstmt.executeQuery();
			while(rs!=null &&  rs.next()) {
				Employee vo = new Employee();
				vo.setEmpId(rs.getInt("emp_id"));
				vo.setFirstName(rs.getString("emp_first_name"));
				vo.setLastName( rs.getString("emp_last_name"));
				employees.getEmployees().add(vo);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(c!=null)
					c.close();
			}catch(Exception e) {
				
			}
		}
		
		return employees;
	}
	
	//CRUD
	
	public void createEmployee(Employee emp) {
		Connection c = null;
		int nextId = getNextEmployeeId();
		System.out.println("Next Employee Id -->" + nextId);
		try {
			c = getConnection();
			PreparedStatement pstmt = c.prepareStatement("INSERT INTO Employee(emp_id,emp_first_name,emp_last_name) VALUES(?,?,?)" ); 
	
			pstmt.setInt(1, nextId);
			pstmt.setString(2, emp.getFirstName());
			pstmt.setString(3, emp.getLastName());
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(c!=null) {
					c.commit();
					c.close();
				}
			}catch(Exception e) {
				
			}
		}
	}
	
	public Employee readEmployee(int empId) {
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement pstmt = c.prepareStatement("SELECT * FROM EMPLOYEE WHERE EMP_ID = ?" ); 
			pstmt.setInt(1, empId);
			ResultSet rs = pstmt.executeQuery();
			if(rs!=null && rs.next()) {
				Employee vo = new Employee();
				vo.setEmpId(rs.getInt("emp_id"));
				vo.setFirstName(rs.getString("emp_first_name"));
				vo.setLastName( rs.getString("emp_last_name"));
				return vo;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(c!=null) {
					c.commit();
					c.close();
				}
			}catch(Exception e) {
				
			}
		}
		
		return null;
	}
	
	public void updateEmployee(int empId,String firsName,String lastName) {
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement pstmt = c.prepareStatement("update EMPLOYEE set emp_first_name=?,emp_last_name=? WHERE EMP_ID = ?" );
			pstmt.setString(1,firsName);
			pstmt.setString(2, lastName);
			pstmt.setInt(3, empId);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(c!=null) {
					c.commit();
					c.close();
				}
			}catch(Exception e) {
				
			}
		}
		
	}
	
	public void deleteEmployee(int empId) {
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement pstmt = c.prepareStatement("DELETE FROM EMPLOYEE WHERE EMP_ID = ?" );
			pstmt.setInt(1, empId);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(c!=null) {
					c.commit();
					c.close();
				}
			}catch(Exception e) {
				
			}
		}
		
	}
	
	public int getNextEmployeeId() {
		Connection c = null;
		try {
			c = getConnection();
			PreparedStatement pstmt = c.prepareStatement("SELECT max(emp_id) + 1 as next_id FROM Employee");
			ResultSet rs = pstmt.executeQuery();
			if(rs!=null &&  rs.next()) {
				return rs.getInt("next_id");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(c!=null)
					c.close();
			}catch(Exception e) {
				
			}
		}
		
		return -1;
		
	}
}
