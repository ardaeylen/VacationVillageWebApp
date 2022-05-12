package com.example.demo.appointment;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path="api/v1/appointment",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class AppointmentController 
{
	private final AppointmentService appointmentService;
	
	@Autowired
	public AppointmentController(AppointmentService appointmentService) 
	{
		super();
		this.appointmentService = appointmentService;
	}
	@GetMapping(path="/{customerId}")
	public List<Appointment> getAppointmentsByCustomerId(@PathVariable("customerId") Long customerId)
	{
		return appointmentService.getAllAppointmentsByCustomerId(customerId);
	}
	
	@PostMapping(path = "/{customerId}/{animatorId}/{activityId}/{date}/{activityType}",params ="register_button")
	public ModelAndView addAppointment(@PathVariable("customerId") Long customerId,@PathVariable("animatorId") Long animatorId,
			@PathVariable("activityId") Long activityId,@PathVariable("date") @DateTimeFormat(pattern="yyyy-MM-dd'T'HH:mm") LocalDateTime date 
			,@PathVariable("activityType") String type)
	{	
		Appointment appointment = new Appointment(activityId,customerId,animatorId,date);

		if(type.equals("Mass"))
		{
		String path = "redirect:localhost://api/v1/massactivity/getAll/"+customerId;
		try 
		{
			appointmentService.addAppointment(appointment);
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		
		return new ModelAndView(path);
		}
		else
		{
			String path = "redirect:localhost://api/v1/individualactivity/getAll/"+customerId;
			try
			{
				appointmentService.addAppointment(appointment);

			}
			catch(Exception ex)
			{
				System.out.println(ex.getMessage());
			}
			return new ModelAndView(path);
		}
	}
	
}
