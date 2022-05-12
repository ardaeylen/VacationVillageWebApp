package com.example.demo.massactivity;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "mass_activity")
public class MassActivity 
{
	@Id
	@Column(name ="activity_id")
	private Long activityId;
	
	@Column(name = "activity_name")
	private String activityName;
	
	@Column(name = "internet_link")
	private String internetLink;
	
	@Column(name ="activity_type")
	private String activityType;

	@Column(name = "type_of_activity")
	private String typeOfActivity;
	
	@Column(name = "date_of_activity")
	private Date dateOfActivity;
	
	@Column(name = "hour_of_activity")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
	private LocalDateTime hourOfActivity;
	
	@Column(name = "capacity")
	private int capacity;
	
	@Column(name = "animator_id")
	private Long animatorId;
	
	public MassActivity(String activityName, String internetLink, String activityType, String typeOfActivity,
			Date dateOfActivity, LocalDateTime hourOfActivity, int capacity, Long animatorId) 
	{
		super();
		this.activityName = activityName;
		this.internetLink = internetLink;
		this.activityType = activityType;
		this.typeOfActivity = typeOfActivity;
		this.dateOfActivity = dateOfActivity;
		this.hourOfActivity = hourOfActivity;
		this.capacity = capacity;
		this.animatorId = animatorId;
	}
	
	public MassActivity(String activityName, String internetLink, String typeOfActivity, Date dateOfActivity,
			LocalDateTime hourOfActivity, int capacity,Long animatorId) 
	{
		super();
		this.activityName = activityName;
		this.internetLink = internetLink;
		this.typeOfActivity = typeOfActivity;
		this.dateOfActivity = dateOfActivity;
		this.hourOfActivity = hourOfActivity;
		this.capacity = capacity;
		this.animatorId = animatorId;
	}

	public MassActivity()
	{
		super();
	}
	public MassActivity(Long activityId, String activityName, String internetLink, String activityType,
			String typeOfActivity, Date dateOfAvtivity, LocalDateTime hourOfActivity, int capacity, Long animatorId) 
	{
		super();
		this.activityId = activityId;
		this.activityName = activityName;
		this.internetLink = internetLink;
		this.activityType = activityType;
		this.typeOfActivity = typeOfActivity;
		this.dateOfActivity = dateOfAvtivity;
		this.hourOfActivity = hourOfActivity;
		this.capacity = capacity;
		this.animatorId = animatorId;
	}




	public Long getActivityId() 
	{
		return activityId;
	}

	public void setActivityId(Long activityId) 
	{
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) 
	{
		this.activityName = activityName;
	}

	public String getInternetLink()
	{
		return internetLink;
	}

	public void setInternetLink(String internetLink)
	{
		this.internetLink = internetLink;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) 
	{
		this.activityType = activityType;
	}

	public String getTypeOfActivity()
	{
		return typeOfActivity;
	}

	public void setTypeOfActivity(String typeOfActivity) {
		this.typeOfActivity = typeOfActivity;
	}

	public Date getDateOfActivity() {
		return dateOfActivity;
	}

	public void setDateOfActivity(Date dateOfAvtivity) 
	{
		this.dateOfActivity = dateOfAvtivity;
	}

	public LocalDateTime getHourOfActivity() 
	{
		return hourOfActivity;
	}

	public void setHourOfActivity(LocalDateTime hourOfActivity) 
	{
		this.hourOfActivity = hourOfActivity;
	}

	public int getCapacity() 
	{
		return capacity;
	}

	public void setCapacity(int capacity) 
	{
		this.capacity = capacity;
	}
	public Long getAnimatorId()
	{
		return animatorId;
	}
	public void setAnimatorId(Long animatorId)
	{
		this.animatorId = animatorId;
	}

	
}
