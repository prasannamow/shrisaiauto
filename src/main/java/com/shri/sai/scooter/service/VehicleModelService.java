package com.shri.sai.scooter.service;

import java.util.List;

import com.shri.sai.scooter.entity.VehicleModel;

public interface VehicleModelService {

	public List<VehicleModel> findAllVehicleModels();

	public VehicleModel getVehicleModel(Integer modelId);

	public VehicleModel addVehicleModel(VehicleModel vehicleModel);

	public VehicleModel updateVehicleModel(VehicleModel vehicleModel);
	
	public Integer findAllModelIdsOrderByDesc();

}
