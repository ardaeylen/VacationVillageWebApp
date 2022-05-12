package com.example.demo.individualactivity;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping(path = "api/v1/individualactivity",method = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST})
public class IndividualActivityController
{
	private final IndividualActivityService individualActivityService;
	private Long customerId;
	private Long animatorId;
	@Autowired
	public IndividualActivityController(IndividualActivityService individualActivityService) 
	{
		super();
		this.individualActivityService = individualActivityService;
	}
	@GetMapping(path="/getAll/{customerId}")
	public ModelAndView getAllIndividualActivities(@PathVariable("customerId") Long customerId)
	{
		this.customerId = customerId;
		ModelAndView individualActivityPage = new ModelAndView("IndividualActivities");
		individualActivityPage.addObject("IndividualActivities",individualActivityService.getAllIndividualActivities());
		individualActivityPage.addObject("customerId",customerId);
		return individualActivityPage;
	}
	@GetMapping(path="/getAll/Animator/{employeeId}")
	public ModelAndView getAllIndividualActivitiesForAnimators(@PathVariable("employeeId") Long employeeId)
	{
		this.animatorId = employeeId;
		ModelAndView individualActivityPage = new ModelAndView("IndividualActivitiesForAnimators");
		individualActivityPage.addObject("IndividualActivities",individualActivityService.getAllIndividualActivities());
		individualActivityPage.addObject("animatorId",animatorId);
		return individualActivityPage;
	}
	@PostMapping(path="/post/Animator",params = "register_button")
	public ModelAndView addIndividualActivity(IndividualActivity individualActivity)
	{
		System.out.println(individualActivity.getHourOfActivity().toString());
		individualActivity.setActivityId((long)0);
		individualActivity.setAnimatorId(this.animatorId);
		individualActivity.setActivityType("Individual");
		individualActivityService.addNewIndividualActivity(individualActivity);
		return getAllIndividualActivitiesForAnimators(this.animatorId);
	}
	@DeleteMapping(path = "/{activityId}", params = "delete_button")
	public ModelAndView deleteIndividualActivity(@PathVariable("activityId") Long activityId)
	{
		individualActivityService.deleteIndividualActivity(activityId);
		return getAllIndividualActivitiesForAnimators(this.animatorId);
	}
}
