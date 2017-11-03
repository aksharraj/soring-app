package com.fb.app.dao;



import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fb.app.bean.Employee;
import com.fb.app.bean.EmployeeListVO;

@Repository
public class EmployeeSpringJdbcDao {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public EmployeeListVO getAllEmployees() {
		EmployeeListVO employees = new EmployeeListVO();
		List<Map<String, Object>> list = this.jdbcTemplate.queryForList("select * from employee");
		for(Map <String,Object> m : list) {
			Employee e = new Employee();
			e.setEmpId(Integer.valueOf(m.get("emp_id").toString()));
			e.setFirstName(m.get("emp_first_name").toString());
			e.setLastName(m.get("emp_last_name").toString());
			employees.addEmployee(e);
		}
		return employees;
	}
	
	 
	public int getAllEmployeeCount() {
		return this.jdbcTemplate.queryForObject("Select count(*) from employee",Integer.class);
	}
	
	public String getAllEmployeeFirstName(int empid) {
		return this.jdbcTemplate.queryForObject("Select emp_fitst_name from employee where emp_id = :empid",new Object[empid],String.class);
	}
	
}
