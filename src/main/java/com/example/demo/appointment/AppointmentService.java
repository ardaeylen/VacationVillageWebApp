package com.example.demo.appointment;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService 
{

	private final AppointmentRepository appointmentRepository;
	
	@Autowired
	public AppointmentService(AppointmentRepository appointmentRepository) 
	{
		super();
		this.appointmentRepository = appointmentRepository;
	}


	public List<Appointment> getAllAppointmentsByCustomerId(Long customerId) 
	{
		return appointmentRepository.findAllByCustomerId(customerId);

	}


	public void addAppointment(Appointment appointment) 
	{
		appointmentRepository.save(appointment);
		
	}

}
