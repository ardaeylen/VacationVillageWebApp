package com.example.demo.customer;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path="api/v1/customer",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class CustomerController 
{
	private final CustomerService customerService;
	@Autowired
	public CustomerController(CustomerService customerService)
	{
		this.customerService=customerService;
	}
	@GetMapping(path="/getAll")
	public ModelAndView getAllCustomers()
	{
		ModelAndView customerPage = new ModelAndView("Customers");
		customerPage.addObject("Customers",customerService.getAllCustomers());
		return customerPage;
	}
	
	@PostMapping(path="/post", params = {"register_button"}) 
	public ModelAndView addNewCustomer(Customer customer) 
	{ 

		customer.setVacationVillageId((long)42); //Arbitrary id is given to the new customer because in the database there is a sequence generator for vacation_id
		customerService.addNewCustomer(customer); 
		ModelAndView mav = new ModelAndView("CustomerPage");
		mav.addObject("customer",customer);
		return mav;
	}
	@PostMapping(path="/{managerId}", params = {"register_button"}) 
	public ModelAndView addNewCustomerByManager(Customer customer) 
	{ 

		customer.setVacationVillageId((long)42); //Arbitrary id is given to the new customer because in the database there is a sequence generator for vacation_id
		customerService.addNewCustomer(customer); 
		return getAllCustomers();
	}
	@PostMapping(path="/registerpage") 
	public ModelAndView addNewCustomer() 
	{ 
		ModelAndView mav = new ModelAndView("LoginPage");
		return mav;
	}
	@PostMapping(path="/{vacationVillageId}",params ="add_Appointment_button")
	public ModelAndView addAppointment(@PathVariable("vacationVillageId") Long vacationVillageId)
	{
		String path = "redirect:http://localhost:8080/api/v1/massactivity/getAll/"+vacationVillageId;
		ModelAndView appointmentPage = new ModelAndView(path);
		return appointmentPage;
	}
	
	@DeleteMapping(path="/{vacationVillageId}" ,params = {"delete_button"})
	public ModelAndView deleteCustomerById(@PathVariable("vacationVillageId") Long id)
	{
		customerService.deleteCustomerById(id);
		return getAllCustomers();
	}
	@PutMapping(path = "put/{vacationVillageid}")
	public void updateCustomer(@PathVariable("vacationVillageid") Long vacationVillageId,@RequestParam(required = false) String newPhoneNumber,
			@RequestParam(required = false) String newPassword, @RequestParam(required = false) String newName)
	{
		customerService.updateCustomer(vacationVillageId,newPhoneNumber,newPassword,newName);
	}
	
	@GetMapping(path="login", params = {"login_button"})
	public ModelAndView loginCustomer(String phoneNumber,String userPassword)
	{
		Customer customer = customerService.findCustomerByPhoneNumberAndPassword(phoneNumber, userPassword);
		if(customer != null)
		{
			if(customer.getVacationVillageId() == 1)
			{
				ModelAndView success = new ModelAndView("ManagerPage");
				success.addObject("customer",customer);
				return success;
			}
			ModelAndView success = new ModelAndView("CustomerPage");
			success.addObject("customer",customer);
			return success;
		}
		else
		{
			System.out.println("Kullanıcı bulunamadı");
			return new ModelAndView("redirect:http://localhost:8080/api/v1/customer/registerpage");
		}
	}
	 
}
