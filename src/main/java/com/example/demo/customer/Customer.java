package com.example.demo.customer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer
{


	@Id
	@Column(name ="vacationvillage_id")
	private Long vacationVillageId;
	
	@Column(name ="phone_number")
	private String phoneNumber;
	
	@Column(name ="usr_password")
	private String userPassword;
	
	@Column(name ="usr_name")
	private String customerName;
	
	@Column(name ="age")
	private int age;
	
	@Column(name ="room_number")
	private int roomNumber;
	
	public Customer()
	{
		super();
	}

	public Customer(String phoneNumber,String customerName, int age, int roomNumber)
	{
		super();
		this.phoneNumber = phoneNumber;
		this.customerName = customerName;
		this.age = age;
		this.roomNumber = roomNumber;
	}
	
	public Long getVacationVillageId() 
	{
		return vacationVillageId;
	}
	public void setVacationVillageId(Long vacationVillageId) 
	{
		this.vacationVillageId = vacationVillageId;
	}
	
	public String getPhoneNumber() 
	{
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) 
	{
		this.userPassword = userPassword;
	}
	public String getCustomerName()
	{
		return customerName;
	}
	public void setCustomerName(String customerName) 
	{
		this.customerName = customerName;
	}
	public int getAge() 
	{
		return age;
	}
	public void setAge(int age) 
	{
		this.age = age;
	}
	public int getRoomNumber() 
	{
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber)
	{
		this.roomNumber = roomNumber;
	}
	
	
}
