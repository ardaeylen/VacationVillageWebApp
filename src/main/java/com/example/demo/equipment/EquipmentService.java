package com.example.demo.equipment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService 
{
	private final EquipmentRepository equipmentRepository;

	@Autowired
	public EquipmentService(EquipmentRepository equipmentRepository)
	{
		super();
		this.equipmentRepository = equipmentRepository;
	}

	public List<Equipment> getAllEquipments() 
	{
		return equipmentRepository.findAll();
	}

	public void addNewEquipment(Equipment equipment)
	{
		Optional<Equipment> equipmentOptional = equipmentRepository.findById(equipment.getEquipmentId());
		if(equipmentOptional.isPresent())
		{
			throw new IllegalStateException("Equipment is valid");
		}
		equipmentRepository.save(equipment);
	}

	public void deleteEquipment(Long equipmentId) 
	{
		equipmentRepository.deleteById(equipmentId);
	}

}
