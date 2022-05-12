package com.example.demo.emergencyinformation;

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
@RequestMapping(path = "api/v1/emergencyinformation",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class EmergencyInformationController 
{
	private final EmergencyInformationService emergencyInformationService;
	private Long activityId;
	@Autowired
	public EmergencyInformationController(EmergencyInformationService emergencyInformationService) 
	{
		super();
		this.emergencyInformationService = emergencyInformationService;
	}
	
	@GetMapping(path = "/get/EmergencyInformation/{activityId}")
	public ModelAndView getEmergencyInformation(@PathVariable("activityId") Long activityId)
	{
		this.activityId = activityId;
		ModelAndView emergencyInfoPage = new ModelAndView("EmergencyInformationPage");
		emergencyInfoPage.addObject("EmergencyInformation",emergencyInformationService.getInfo(activityId));
		return emergencyInfoPage;
	
	}
	@PostMapping(path = "/post",params = "register_button")
	public ModelAndView addNewEmergencyInformation(EmergencyInformation emergencyInformation)
	{
		emergencyInformation.setActivityId(this.activityId);
		emergencyInformationService.addEmergencyInformation(emergencyInformation);
		return getEmergencyInformation(activityId);

	}
	@DeleteMapping(path = "/{activityId}")
	public ModelAndView deleteEmergencyInformation(@PathVariable("activityId") Long activityId)
	{
		emergencyInformationService.deleteEmergencyInformation(activityId);
		return getEmergencyInformation(activityId);
	}
	

}
