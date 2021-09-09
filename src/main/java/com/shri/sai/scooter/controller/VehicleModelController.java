package com.shri.sai.scooter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shri.sai.scooter.entity.VehicleModel;
import com.shri.sai.scooter.service.VehicleModelService;

@Controller
@RequestMapping(value = "/vehicle")
public class VehicleModelController {

	@Autowired
	private VehicleModelService vehicleModelService;

	@GetMapping(value = "/model")
	public String vehicleModelForm(Model model) {
		model.addAttribute("vehiclemodel", vehicleModelService.findAllVehicleModels());
		return "vehiclemodel";
	}

	@GetMapping("/model/create/form")
	public String createNewVehicleModelForm(Model model) {
		VehicleModel objVehicleModel = new VehicleModel();
		model.addAttribute("vehiclemodel", objVehicleModel);
		return "createvehiclemodel";
	}

	@PostMapping(value = "/model/save")
	public String saveVehicleModelData(@ModelAttribute("createvehiclemodel") VehicleModel vehicleModel) {
		vehicleModelService.addVehicleModel(vehicleModel);
		return "redirect:/vehicle/model";
	}
}
