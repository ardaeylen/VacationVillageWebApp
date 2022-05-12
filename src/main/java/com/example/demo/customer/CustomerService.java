package com.example.demo.customer;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CustomerService 
{
	private final CustomerRepository customerRepository;
	@Autowired
	public CustomerService(CustomerRepository customerRepository)
	{
		this.customerRepository = customerRepository;
	}
	public List<Customer> getAllCustomers() 
	{
		return customerRepository.findAll();
	}
	public void addNewCustomer(Customer customer) 
	{
		Optional<Customer> customerOptional = customerRepository.findCustomerByPhoneNumber(customer.getPhoneNumber());
		if(customerOptional.isPresent())
		{
			throw new IllegalStateException("Phone number exists.");
		}
		customerRepository.save(customer);
	}
	public void deleteCustomerById(Long id) 
	{
		Optional<Customer> customerById = customerRepository.findById(id);
		if(!customerById.isPresent())
		{
			throw new IllegalStateException("Customer haven't found by the given id = "+id);
		}
		customerRepository.deleteById(id);
	}
	@Transactional
	public void updateCustomer(Long customerId, String newPhoneNumber, String newPassword, String newName) 
	{
		if(!customerRepository.findById(customerId).isPresent())
		{
			throw new IllegalStateException("Customer haven't found by the given id = "+customerId);
		}
		Customer customer = (customerRepository.findById(customerId)).orElseThrow(() -> new IllegalStateException("Customer haven't found by the given id = "+customerId));
		
		if(newPhoneNumber != null && !newPhoneNumber.isEmpty())
		{
			customer.setPhoneNumber(newPhoneNumber);
		}
		if(newPassword!=null &&  !newPassword.isEmpty())
		{
			customer.setUserPassword(newPassword);
		}
		if(newName != null && !newName.isEmpty())
		{
			customer.setCustomerName(newName);
		}
		
	}
	public Customer findCustomerByPhoneNumberAndPassword(String phoneNumber,String userPassword)
	{
		Optional<Customer> customerOptional = customerRepository.findCustomerByPhoneAndPassword(phoneNumber, userPassword);
		if(customerOptional.isPresent())
		{
			 Customer customer = customerRepository.findCustomerByPhoneAndPassword(phoneNumber, userPassword).orElseThrow(() -> new IllegalStateException("x"));
			 return customer;
		}
		else
		{
			return null;
		}
	}
	public Customer findCustomerById(Long vacationVillageId) 
	{
		return customerRepository.getById(vacationVillageId);
	}

}
