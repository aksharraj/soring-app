package com.fb.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fb.app.bean.Employee;
import com.fb.app.bean.EmployeeListVO;
import com.fb.app.dao.EmployeeJdbcDao;
import com.fb.app.dao.EmployeeJpaDao;
import com.fb.app.dao.EmployeeSpringJdbcDao;

@Service
public class EmployeeService {

	@Autowired
	EmployeeJdbcDao dao;
	
	@Autowired
	EmployeeSpringJdbcDao springdao;
	
	@Autowired
	EmployeeJpaDao jpaDao;
	
	public EmployeeListVO getEmployeesList() {
		EmployeeListVO listvo = new EmployeeListVO();
		listvo.getEmployees().addAll(jpaDao.getAllEmployees());
		return listvo;
	}
	
	public void createEmployee(Employee emp) {
		jpaDao.createEmployee(emp);
	}
	
	public Employee readEmployee(int empid) {
		return dao.readEmployee(empid);
	}
	
	public void updateEmployee(int empid,String firstName,String lastName) {
		dao.updateEmployee(empid,firstName,lastName);
	}
	public void deleteEmployee(int empId) {
		dao.deleteEmployee(empId);
	}
}
