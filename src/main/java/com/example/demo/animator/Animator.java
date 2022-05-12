package com.example.demo.animator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "animator")
public class Animator 
{
	@Id
	@Column(name = "employee_id")
	private Long employeeId;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "usr_password")
	private String userPassword;
	
	@Column(name = "name")
	private String userName;
	
	@Column(name = "expertise_area")
	private String expertiseArea;
	
	public Animator()
	{
		super();
	}
	
	public Animator(String phoneNumber, String userName, String expertiseArea) 
	{
		super();
		this.phoneNumber = phoneNumber;
		this.userName = userName;
		this.expertiseArea = expertiseArea;
	}

	public Long getEmployeeId() 
	{
		return employeeId;
	}

	public void setEmployeeId(Long employeeId)
	{
		this.employeeId = employeeId;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}

	public String getUserPassword() 
	{
		return userPassword;
	}

	public void setUserPassword(String userPassword) 
	{
		this.userPassword = userPassword;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getExpertiseArea() 
	{
		return expertiseArea;
	}

	public void setExpertiseArea(String expertiseArea)
	{
		this.expertiseArea = expertiseArea;
	}

	
}
