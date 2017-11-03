package com.fb.app.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="department")
@XmlAccessorType(XmlAccessType.NONE)
@Entity
@Table(name="department")
public class Department {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@XmlElement
	private int deptId;
	
	@XmlElement
	@Column(name="dept_name")
	private String deptName;
	
	@XmlElement
	@Column(name="dept_region")
	private String deptRegion;
	
	

	public Department() {
	}



	public Department(int deptId, String deptName, String deptRegion) {
		super();
		this.deptId = deptId;
		this.deptName = deptName;
		this.deptRegion = deptRegion;
	}



	public int getDeptId() {
		return deptId;
	}



	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}



	public String getDeptName() {
		return deptName;
	}



	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}



	public String getDeptRegion() {
		return deptRegion;
	}



	public void setDeptRegion(String deptRegion) {
		this.deptRegion = deptRegion;
	}
	
	
	
	

}
