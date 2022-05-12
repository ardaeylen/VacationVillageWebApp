package com.example.demo.equipperson;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "equip_person")
public class EquipPerson 
{
	@Id
	@Column(name = "ssn")
	private String ssn;

	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "name")
	private String equipPersonName;
	
	@Column(name = "surname")
	private String equipPersonSurName;
	
	public EquipPerson()
	{
		super();
	}
	
	public String getSsn() 
	{
		return ssn;
	}

	public void setSsn(String ssn)
	{
		this.ssn = ssn;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}

	public String getEquipPersonName() 
	{
		return equipPersonName;
	}

	public void setEquipPersonName(String equipPersonName) 
	{
		this.equipPersonName = equipPersonName;
	}

	public String getEquipPersonSurName() 
	{
		return equipPersonSurName;
	}

	public void setEquipPersonSurName(String equipPersonSurName) 
	{
		this.equipPersonSurName = equipPersonSurName;
	}

	public EquipPerson(String ssn, String phoneNumber, String equipPersonName, String equipPersonSurName) 
	{
		super();
		this.ssn = ssn;
		this.phoneNumber = phoneNumber;
		this.equipPersonName = equipPersonName;
		this.equipPersonSurName = equipPersonSurName;
	}
}
