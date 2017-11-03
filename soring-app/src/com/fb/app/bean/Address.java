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

@XmlRootElement(name="addresss")
@XmlAccessorType(XmlAccessType.NONE)
@Entity
@Table(name="address")
public class Address {
	
	@Id
	@Column(name="addr_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	@XmlElement
	private int addressId;
	
	
	@XmlElement
	@Column(name="addr_adress_line1")
	private String addressLine1;
	
	@XmlElement
	@Column(name="addr_address_line2")
	private String addressLine2;
	
	@XmlElement
	@Column(name="addr_address_city")
	private String city;
	
	@XmlElement
	@Column(name="addr_address_state")
	private String state;
	
	

	public Address() {
		
	}


	public Address(int addressId, String addressLine1, String addressLine2, String city, String state) {
		super();
		this.addressId = addressId;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.state = state;
	}


	public int getAddressId() {
		return addressId;
	}


	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}


	public String getAddressLine1() {
		return addressLine1;
	}


	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}


	public String getAddressLine2() {
		return addressLine2;
	}


	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}
	
}
