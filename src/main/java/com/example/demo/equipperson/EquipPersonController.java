package com.example.demo.equipperson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "api/v1/equipperson",method = {RequestMethod.GET,RequestMethod.DELETE,RequestMethod.POST})
public class EquipPersonController 
{
	private final EquipPersonService equipPersonService;
	
	@Autowired
	public EquipPersonController(EquipPersonService equipPersonService)
	{
		super();
		this.equipPersonService = equipPersonService;
	}
	
	@GetMapping(path = "/getAll")
	public ModelAndView getAllEquipPersons()
	{
		ModelAndView equipPersonPage = new ModelAndView("EquipPersons");
		equipPersonPage.addObject("EquipPersons",equipPersonService.getAllEquipPersons());
		return equipPersonPage;
	}
	
	@PostMapping(path = "/post",params = "register_button")
	public ModelAndView addEquipPerson(EquipPerson equipPerson)
	{
		equipPersonService.addEquipPerson(equipPerson);
		return getAllEquipPersons();
	}
	@DeleteMapping(path = "/{ssn}", params = "delete_button")
	public ModelAndView deleteEquipPerson(@PathVariable("ssn") String ssn)
	{
		equipPersonService.deleteEquipPerson(ssn);
		return getAllEquipPersons();
	}
}
