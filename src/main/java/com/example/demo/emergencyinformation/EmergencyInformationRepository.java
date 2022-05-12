package com.example.demo.emergencyinformation;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmergencyInformationRepository extends JpaRepository<EmergencyInformation,Long>
{
	@Query("SELECT E FROM EmergencyInformation E WHERE E.activityId = ?1")
	Optional<EmergencyInformation> getInfoByActivityId(Long activityId);
	
}
