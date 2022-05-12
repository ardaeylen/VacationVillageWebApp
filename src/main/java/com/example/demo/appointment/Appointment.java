package com.example.demo.appointment;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@IdClass(Appointment.class)
@Table(name = "appointment")
public class Appointment implements Serializable
{
	@Id
	@Column(name = "activity_id")
	private Long activityId;
	
	@Id
	@Column(name = "customer_id")
	private Long customerId;
	
	@Id
	@Column(name = "animator_id")
	private Long animatorId;
	
	@Id
	@Column(name = "date_and_hour")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
	private LocalDateTime dateAndHour;

	public Appointment(Long activityId, Long customerId, Long animatorId, LocalDateTime dateAndHour) 
	{
		super();
		this.activityId = activityId;
		this.customerId = customerId;
		this.animatorId = animatorId;
		this.dateAndHour = dateAndHour;
	}
	public Appointment()
	{
		super();
	}
	public Long getActivityId()
	{
		return activityId;
	}
	public void setActivityId(Long activityId)
	{
		this.activityId = activityId;
	}
	public Long getCustomerId() 
	{
		return customerId;
	}
	public void setCustomerId(Long customerId) 
	{
		this.customerId = customerId;
	}
	public Long getAnimatorId() 
	{
		return animatorId;
	}
	public void setAnimatorId(Long animatorId) 
	{
		this.animatorId = animatorId;
	}
	public LocalDateTime getDateAndHour()
	{
		return dateAndHour;
	}
	public void setDateAndHour(LocalDateTime dateAndHour)
	{
		this.dateAndHour = dateAndHour;
	}
	
}
