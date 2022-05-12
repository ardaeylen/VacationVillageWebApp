package com.example.demo.appointment;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppointmentRepository extends JpaRepository<Appointment,Long>
{
	
	@Query("SELECT A FROM Appointment A WHERE A.customerId = ?1")
	List<Appointment> findAllByCustomerId(Long customerId);
}
