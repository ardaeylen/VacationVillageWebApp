package com.example.demo.animator;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AnimatorRepository extends JpaRepository<Animator,Long>
{
	@Query("SELECT A FROM Animator A WHERE A.phoneNumber=?1")
	Optional<Animator> getAnimatorByPhoneNumber(String phoneNumber);
	
	@Query("SELECT A FROM Animator A WHERE A.phoneNumber = ?1 AND A.userPassword = ?2")
	Optional<Animator> findAnimatorByPhoneAndPassword(String phoneNumber,String userPassword);
}
