package com.example.demo.individualactivity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "individual_activity")
public class IndividualActivity 
{
	@Id
	@Column(name = "activity_id")
	private Long activityId;
	
	@Column(name = "activity_name")
	private String activityName;
	
	@Column(name = "internet_lik")
	private String internetLink;
	
	@Column(name = "activity_type")
	private String activityType;
	
	@Column(name = "age_requirement")
	private int ageRequirement;
	
	@Column(name = "animator_id")
	private Long animatorId;

	@Column(name = "hour_of_activity")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) 
	private LocalDateTime hourOfActivity;
	
	public IndividualActivity(String activityName, String internetLink, int ageRequirement, Long animatorId,
			LocalDateTime hourOfActivity) 
	{
		super();
		this.activityName = activityName;
		this.internetLink = internetLink;
		this.ageRequirement = ageRequirement;
		this.animatorId = animatorId;
		this.hourOfActivity = hourOfActivity;
	}
	
	public IndividualActivity(String activityName, String internetLink, int ageRequirement)
	{
		super();
		this.activityName = activityName;
		this.internetLink = internetLink;
		this.ageRequirement = ageRequirement;
	}
	public IndividualActivity() 
	{
		super();
	}

	public IndividualActivity(Long activityId, String activityName, String internetLink, String activityType,
			int ageRepuirement, Long animatorId, LocalDateTime hourOfActivity) 
	{
		super();
		this.activityId = activityId;
		this.activityName = activityName;
		this.internetLink = internetLink;
		this.activityType = activityType;
		this.ageRequirement = ageRepuirement;
		this.animatorId = animatorId;
		this.hourOfActivity = hourOfActivity;
	}

	public Long getActivityId()
	{
		return activityId;
	}

	public void setActivityId(Long activityId) 
	{
		this.activityId = activityId;
	}

	public String getActivityName() 
	{
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

	public String getActivityType() 
	{
		return activityType;
	}

	public void setActivityType(String activityType)
	{
		this.activityType = activityType;
	}

	public int getAgeRequirement() 
	{
		return ageRequirement;
	}

	public void setAgeRequirement(int ageRepuirement) 
	{
		this.ageRequirement = ageRepuirement;
	}

	public Long getAnimatorId()
	{
		return animatorId;
	}

	public void setAnimatorId(Long animatorId) 
	{
		this.animatorId = animatorId;
	}
	public LocalDateTime getHourOfActivity()
	{
		return hourOfActivity;
	}

	public void setHourOfActivity(LocalDateTime hourOfActivity) 
	{
		this.hourOfActivity = hourOfActivity;
	}
	
}
