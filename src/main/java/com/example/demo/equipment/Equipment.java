package com.example.demo.equipment;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equipment")
public class Equipment 
{
	@Id
	@Column(name = "equipment_id")
	private Long equipmentId;
	
	@Column(name = "equip_person_ssn")
	private String equipPersonSsn;
	
	@Column(name = "equipment_name")
	private String equipmentName;
	
	@Column(name = "purpose")
	private String purpose;
	
	public Equipment()
	{
		super();
	}
	
	public Equipment(Long equipmentId, String equipPersonSsn, String equipmentName, String purpose)
	{
		super();
		this.equipmentId = equipmentId;
		this.equipPersonSsn = equipPersonSsn;
		this.equipmentName = equipmentName;
		this.purpose = purpose;
	}

	public Equipment(String equipPersonSsn, String equipmentName, String purpose) 
	{
		super();
		this.equipPersonSsn = equipPersonSsn;
		this.equipmentName = equipmentName;
		this.purpose = purpose;
	}

	public Long getEquipmentId() 
	{
		return equipmentId;
	}

	public void setEquipmentId(Long equipmentId) 
	{
		this.equipmentId = equipmentId;
	}

	public String getEquipPersonSsn() {
		return equipPersonSsn;
	}

	public void setEquipPersonSsn(String equipPersonSsn) 
	{
		this.equipPersonSsn = equipPersonSsn;
	}

	public String getEquipmentName()
	{
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) 
	{
		this.equipmentName = equipmentName;
	}

	public String getPurpose() 
	{
		return purpose;
	}

	public void setPurpose(String purpose)
	{
		this.purpose = purpose;
	}
	
}
