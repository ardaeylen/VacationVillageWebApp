package com.example.demo.individualactivity;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.massactivity.MassActivity;

@Service
public class IndividualActivityService 
{
	private final IndividualActivityRepository individualActivityRepository;

	@Autowired
	public IndividualActivityService(IndividualActivityRepository individualActivityRepository) 
	{
		super();
		this.individualActivityRepository = individualActivityRepository;
	}

	public List<IndividualActivity> getAllIndividualActivities()
	{
		return individualActivityRepository.findAll();
	}

	public void addNewIndividualActivity(IndividualActivity individualActivity) 
	{
		Optional<IndividualActivity> indActOptional = individualActivityRepository.findById(individualActivity.getActivityId());
		if(indActOptional.isPresent())
		{
			throw new IllegalStateException("");
		}
		individualActivityRepository.save(individualActivity);
		
	}

	public void deleteIndividualActivity(Long activityId) 
	{
		Optional<IndividualActivity> indActOptional = individualActivityRepository.findById(activityId);
		if(!indActOptional.isPresent())
		{
			throw new IllegalStateException("");
		}
		individualActivityRepository.deleteById(activityId);
	}
}
