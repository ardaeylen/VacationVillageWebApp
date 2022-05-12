package com.example.demo.equipperson;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EquipPersonRepository extends JpaRepository<EquipPerson,String>
{
	@Query("SELECT E FROM EquipPerson E WHERE E.ssn = ?1")
	Optional<EquipPerson> findEquipPersonBySsn(String ssn);
}
