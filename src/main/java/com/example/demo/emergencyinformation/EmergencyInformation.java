package com.example.demo.emergencyinformation;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;



@Entity
@Table(name = "emergency_info")
public class EmergencyInformation implements Serializable
{
	@Id
	@Column(name ="activity_id")
	private Long activityId;

	@Column(name = "locker_number")
	private Long lockerNumber;
	
	@Column(name = "phone_number")
	private String phoneNumber;

	public EmergencyInformation() 
	{
		super();
	}

	public EmergencyInformation(Long activityId, Long lockerNumber, String phoneNumber) 
	{
		super();
		this.activityId = activityId;
		this.lockerNumber = lockerNumber;
		this.phoneNumber = phoneNumber;
	}

	public EmergencyInformation(Long lockerNumber, String phoneNumber) 
	{
		super();
		this.lockerNumber = lockerNumber;
		this.phoneNumber = phoneNumber;
	}

	public Long getActivityId()
	{
		return activityId;
	}

	public void setActivityId(Long activityId) 
	{
		this.activityId = activityId;
	}

	public Long getLockerNumber() 
	{
		return lockerNumber;
	}

	public void setLockerNumber(Long lockerNumber) 
	{
		this.lockerNumber = lockerNumber;
	}

	public String getPhoneNumber() 
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	
}
