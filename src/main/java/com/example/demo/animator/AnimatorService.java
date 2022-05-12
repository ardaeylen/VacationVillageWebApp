package com.example.demo.animator;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.customer.Customer;

@Service
public class AnimatorService 
{

	private final AnimatorRepository animatorRepository;
	
	@Autowired
	public AnimatorService(AnimatorRepository animatorRepository) 
	{
		super();
		this.animatorRepository = animatorRepository;
	}

	
	public List<Animator> getAllAnimators() 
	{
	
		return animatorRepository.findAll();
	}
	
	public void addNewAnimator(Animator animator)
	{
		Optional<Animator> animatorOptional = animatorRepository.getAnimatorByPhoneNumber(animator.getPhoneNumber());
		if(animatorOptional.isPresent())
		{
			throw new IllegalStateException("Animator is valid");
		}
		animatorRepository.save(animator);
	}
	public void deleteAnimator(Long id)
	{
		Optional <Animator> animatorOptional = animatorRepository.findById(id);
		if(!animatorOptional.isPresent())
		{
			throw new IllegalStateException("Animator does not exit");
			
		}
		animatorRepository.deleteById(id);
	}


	public Animator findAnimatorByPhoneNumberAndPassword(String phoneNumber, String userPassword) 
	{
		Optional<Animator> animatorOptional = animatorRepository.findAnimatorByPhoneAndPassword(phoneNumber, userPassword);
		if(animatorOptional.isPresent())
		{
			Animator animator = animatorRepository.findAnimatorByPhoneAndPassword(phoneNumber, userPassword).orElseThrow(
					
					()-> new IllegalStateException("Animator does not exist."));
			return animator;
		}
		return null;
		
	}

}
