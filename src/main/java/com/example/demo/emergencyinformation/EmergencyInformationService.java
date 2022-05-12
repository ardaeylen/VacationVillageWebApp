package com.example.demo.emergencyinformation;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmergencyInformationService 
{
	private final EmergencyInformationRepository emergencyInformationRepository;

	@Autowired
	public EmergencyInformationService(EmergencyInformationRepository emergencyInformationRepository) 
	{
		super();
		this.emergencyInformationRepository = emergencyInformationRepository;
	}

	public EmergencyInformation getInfo(Long activityId) 
	{
		Optional<EmergencyInformation> emergencyInfoOptional = emergencyInformationRepository.getInfoByActivityId(activityId);
		if(emergencyInfoOptional.isPresent())
		{
			EmergencyInformation info = emergencyInfoOptional.orElseThrow(()-> new IllegalStateException(""));
			return info;
		}
		return null;
		
	}

	public void addEmergencyInformation(EmergencyInformation emergencyInformation)
	{
		emergencyInformationRepository.save(emergencyInformation);
		
	}

	public void deleteEmergencyInformation(Long activityId)
	{
		emergencyInformationRepository.deleteById(activityId);
		
	}

	
}
