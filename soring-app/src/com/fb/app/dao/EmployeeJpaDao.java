package com.fb.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.fb.app.bean.Employee;
import com.fb.app.bean.EmployeeListVO;

@Repository
@Transactional
public class EmployeeJpaDao {

	@PersistenceContext
	EntityManager em;
	
	
	public List<Employee> getAllEmployees() {
		return em.createQuery("from Employee",Employee.class).getResultList();
	}
	
	public void createEmployee(Employee emp) {
		em.persist(emp);
	}
	
	public Employee getEmployeeById(int empid) {
		return em.find(Employee.class, empid);
	}
	
	public void deleteEmployee(int empid) {
		Employee emp = getEmployeeById(empid);
		em.remove(emp);
	}
}
