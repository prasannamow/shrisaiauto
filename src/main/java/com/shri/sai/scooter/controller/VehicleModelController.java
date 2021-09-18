package com.shri.sai.scooter.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
		String currentDate = getCurrentTimeUsingDate();
		vehicleModel.setCreatedBy("admin");
		vehicleModel.setCreatedDate(currentDate);
		vehicleModelService.addVehicleModel(vehicleModel);
		return "redirect:/vehicle/model";
	}

	@GetMapping(value = "/model/update/form/{modelId}")
	public String updateVehicleModelForm(@PathVariable Integer modelId, Model model) {
		model.addAttribute("updatevehiclemodel", vehicleModelService.getVehicleModel(modelId));
		return "updatevehiclemodel";
	}

	@PostMapping(value = "/model/update/{modelId}")
	public String updateEnquiry(@PathVariable Integer modelId,
			@ModelAttribute("updatevehiclemodel") VehicleModel updateVehicleModel, Model model) {
		String updatedDate = getCurrentTimeUsingDate();
		VehicleModel vehicleModel = vehicleModelService.getVehicleModel(modelId);
		vehicleModel.setBatterySize(updateVehicleModel.getBatterySize());
		vehicleModel.setChargingTime(updateVehicleModel.getChargingTime());
		vehicleModel.setModelName(updateVehicleModel.getModelName());
		vehicleModel.setMotorCapacity(updateVehicleModel.getMotorCapacity());
		vehicleModel.setPayload(updateVehicleModel.getPayload());
		vehicleModel.setPrice(updateVehicleModel.getPrice());
		vehicleModel.setRange(updateVehicleModel.getRange());
		vehicleModel.setSpeed(updateVehicleModel.getSpeed());
		vehicleModel.setIsActive(true);
		vehicleModel.setUpdatedBy("admin");
		vehicleModel.setUpdatedDate(updatedDate);
		vehicleModelService.updateVehicleModel(vehicleModel);
		return "redirect:/vehicle/model";
	}

	private String getCurrentTimeUsingDate() {
		Date date = new Date();
		String strDateFormat = "dd-MM-yyyy";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		String formattedDate = dateFormat.format(date);
		return formattedDate;
	}
}