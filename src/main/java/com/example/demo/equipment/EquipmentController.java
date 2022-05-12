package com.example.demo.equipment;

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
@RequestMapping(path = "api/v1/equipment",method = {RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE})
public class EquipmentController 
{
	private final EquipmentService equipmentService;

	@Autowired
	public EquipmentController(EquipmentService equipmentService)
	{
		super();
		this.equipmentService = equipmentService;
	}
	
	@GetMapping(path="/getAll")
	public ModelAndView getAllEquipments()
	{
		ModelAndView equipmentPage = new ModelAndView("Equipments");
		equipmentPage.addObject("Equipments",equipmentService.getAllEquipments());
		return equipmentPage;
	}
	
	@PostMapping(path = "/post",params = "register_button")
	public ModelAndView addNewEquipment(Equipment equipment)
	{
		equipment.setEquipmentId((long)0);
		equipmentService.addNewEquipment(equipment);
		return getAllEquipments();
	}
	@DeleteMapping(path = "/{equipmentId}",params = "delete_button")
	public ModelAndView deleteEquipment(@PathVariable("equipmentId") Long equipmentId)
	{
		equipmentService.deleteEquipment(equipmentId);
		return getAllEquipments();
	}
	
}
