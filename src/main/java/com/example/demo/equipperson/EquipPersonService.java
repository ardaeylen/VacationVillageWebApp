package com.example.demo.equipperson;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipPersonService 
{

	private final EquipPersonRepository equipPersonRepository;
	
	@Autowired
	public EquipPersonService(EquipPersonRepository equipPersonRepository) 
	{
		super();
		this.equipPersonRepository = equipPersonRepository;
	}


	public List<EquipPerson> getAllEquipPersons() 
	{
		return equipPersonRepository.findAll();	
	}


	public void addEquipPerson(EquipPerson equipPerson) 
	{
		Optional<EquipPerson> equipPersonOptional = equipPersonRepository.findEquipPersonBySsn(equipPerson.getSsn());
		if(equipPersonOptional.isPresent())
		{
			throw new IllegalStateException("Equip Person Already Exists");
		}
		equipPersonRepository.save(equipPerson);
	}


	public void deleteEquipPerson(String ssn) 
	{
		Optional<EquipPerson> equipPersonOptional = equipPersonRepository.findEquipPersonBySsn(ssn);
		if(!equipPersonOptional.isPresent())
		{
			throw new IllegalStateException("Equip Person Does Not Exist.");
		}
		equipPersonRepository.deleteById(ssn);
	}

}
