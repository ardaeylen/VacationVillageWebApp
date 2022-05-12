package com.example.demo.massactivity;
import com.example.demo.customer.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.customer.Customer;

@RestController
@RequestMapping(path = "api/v1/massactivity",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class MassActivityController 
{
	private final MassActivityService massActivityService;
	private Long customerId;
	private Long animatorId;
	
	@Autowired
	public MassActivityController(MassActivityService massActivityService) 
	{
		super();
		this.massActivityService = massActivityService;
	}
	
	@GetMapping(path="/getAll/{customerId}")
	public ModelAndView getAllMassActivities(@PathVariable("customerId") Long customerId)
	{
		this.customerId = customerId;
		ModelAndView massActivityPage = new ModelAndView("MassActivities");
		massActivityPage.addObject("MassActivities",massActivityService.getAllMassActivities());
		massActivityPage.addObject("customerId",customerId);
		return massActivityPage;
	}
	@GetMapping(path="/getAll/Animator/{animatorId}")
	public ModelAndView getAllMassActivitiesForAnimators(@PathVariable("animatorId") Long animatorId)
	{
		this.animatorId = animatorId;
		ModelAndView massActivityPage = new ModelAndView("MassActivitiesForAnimators");
		massActivityPage.addObject("MassActivities",massActivityService.getAllMassActivities());
		massActivityPage.addObject("animatorId",animatorId);
		return massActivityPage;
	}
	@PostMapping(path="/post",params = "register_button")
	public ModelAndView addMassActivity(MassActivity massActivity)
	{
		massActivity.setActivityId((long)0);
		massActivity.setActivityType("Mass");
		massActivity.setAnimatorId(this.animatorId);
		massActivityService.addNewMassActivity(massActivity);
		return getAllMassActivitiesForAnimators(this.animatorId);
	}
	@DeleteMapping(path = "/{activityId}", params = "delete_button")
	public ModelAndView deleteMassActivity(@PathVariable("activityId") Long activityId)
	{
		massActivityService.deleteMassActivity(activityId);
		return getAllMassActivitiesForAnimators(this.animatorId);
	}
	


}
