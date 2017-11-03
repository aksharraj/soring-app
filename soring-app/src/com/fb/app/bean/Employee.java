package com.fb.app.bean;

import java.util.List;

import javax.annotation.Generated;
import javax.annotation.Resource;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.context.annotation.Scope;

@XmlRootElement(name="employee")
@XmlAccessorType(XmlAccessType.NONE)
@Entity
@Table(name="employee")
public class Employee {
	
	@XmlElement
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int empId;
	
	@XmlElement
	@Column(name="emp_first_name")
	private String firstName;
	
	@XmlElement
	@Column(name="emp_last_name")
	private String lastName;
	
	@OneToOne
	@JoinColumn(name="emp_dept_id")
	private Department department;
	
	
	@OneToMany
	@JoinColumn(name="emp_id")
	private List<Address> addresses;
	
	
	
	public Employee() {
		
	}
	
	public Employee(int empId, String firstName, String lastName,Department department,List<Address> addresses) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = department;
		this.addresses = addresses;
	}
	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Department getDepartment() {
		
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}
	
	
	

}
