package com.example.demo.customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long>
{
	@Query("SELECT C FROM Customer C WHERE C.phoneNumber = ?1")
	Optional<Customer> findCustomerByPhoneNumber(String phoneNumber);
	
	@Query("SELECT C FROM Customer C WHERE C.phoneNumber = ?1 AND C.userPassword = ?2")
	Optional<Customer> findCustomerByPhoneAndPassword(String phoneNumber,String userPassword);

		
}
