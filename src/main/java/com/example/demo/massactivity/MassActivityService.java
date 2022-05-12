package com.example.demo.massactivity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MassActivityService 
{
	private final MassActivityRepository massActivityRepository;

	@Autowired
	public MassActivityService(MassActivityRepository massActivityRepository)
	{
		super();
		this.massActivityRepository = massActivityRepository;
	}

	public List<MassActivity> getAllMassActivities() 
	{
		return massActivityRepository.findAll();
	}

	public void addNewMassActivity(MassActivity massActivity) 
	{
		Optional<MassActivity> massActivityOptional = massActivityRepository.findById(massActivity.getActivityId());
		if(massActivityOptional.isPresent()) 
		{
			throw new IllegalStateException("Mass activity has already been exits");
		
		}
		massActivityRepository.save(massActivity);
	}

	public void deleteMassActivity(Long activityId) 
	{
		Optional<MassActivity> massActivityOptional = massActivityRepository.findById(activityId);
		if(!massActivityOptional.isPresent())
		{
			throw new IllegalStateException("Mass activity does not exit with the given activity id = "+activityId);
		}
		massActivityRepository.deleteById(activityId);
		
	}

	public MassActivity getActivityById(Long activityId) 
	{
		
		return massActivityRepository.getById(activityId);
	}
	
}