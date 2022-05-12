package com.example.demo.animator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.customer.Customer;

@RestController
@RequestMapping(path="api/v1/animator",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})
public class AnimatorController 
{
	private final AnimatorService animatorService;

	@Autowired
	public AnimatorController(AnimatorService animatorService)
	{
		super();
		this.animatorService = animatorService;
	}
	@GetMapping(path="/getAll")
	public ModelAndView getAllAnimators()
	{
		ModelAndView animatorPage = new ModelAndView("Animators");
		animatorPage.addObject("Animator",animatorService.getAllAnimators());
		return animatorPage;
	}
	@GetMapping(path="/{employeeId}")
	public ModelAndView goToAnimatorActivityOptionPage(@PathVariable("employeeId") Long animatorId)
	{
		ModelAndView optionPage = new ModelAndView("AnimatorActivityOptionPage");
		optionPage.addObject("animatorId",animatorId);
		return optionPage;
	}
	@PostMapping(path="/post",params = {"register_button"})
	public ModelAndView addAnimator(Animator animator)
	{
		animator.setEmployeeId((long)42);
		animatorService.addNewAnimator(animator);
		return getAllAnimators();
	}
	@DeleteMapping(path="/{employeeId}",params = {"delete_button"})
	public ModelAndView deleteAnimator(@PathVariable("employeeId") Long employeeId)
	{
		animatorService.deleteAnimator(employeeId);
		return getAllAnimators();
	}
	
	@GetMapping(path="Animatorlogin", params = {"login_button"})
	public ModelAndView loginAnimator(String phoneNumber,String userPassword)
	{
		Animator animator = animatorService.findAnimatorByPhoneNumberAndPassword(phoneNumber, userPassword);
		if(animator != null)
		{
			
			ModelAndView success = new ModelAndView("AnimatorPage");
			success.addObject("animator",animator);
			return success;
		}
		else
		{
			System.out.println("Kullanıcı bulunamadı");
			return new ModelAndView("redirect:http://localhost:8080/api/v1/animator/registerpage");
		}
	}
	@PostMapping(path="/registerpage") 
	public ModelAndView addNewAnimator() 
	{ 
		ModelAndView mav = new ModelAndView("AnimatorLoginPage");
		return mav;
	}

}
