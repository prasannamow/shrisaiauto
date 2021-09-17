package com.shri.sai.scooter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shri.sai.scooter.entity.VehicleModel;
import com.shri.sai.scooter.repository.VehicleModelRepository;
import com.shri.sai.scooter.service.VehicleModelService;

@Service
public class VehicleModelServiceImpl implements VehicleModelService {

	@Autowired
	private VehicleModelRepository vehicleModelRepository;

	@Override
	public List<VehicleModel> findAllVehicleModels() {
		return (List<VehicleModel>) vehicleModelRepository.findAll();
	}

	@Override
	public VehicleModel addVehicleModel(VehicleModel vehicleModel) {
		return vehicleModelRepository.save(vehicleModel);
	}

	@Override
	public VehicleModel getVehicleModel(Integer modelId) {
		return vehicleModelRepository.findByModelId(modelId);
	}

	@Override
	public VehicleModel updateVehicleModel(VehicleModel vehicleModel) {
		return vehicleModelRepository.save(vehicleModel);
	}

	@Override
	public Integer findAllModelIdsOrderByDesc() {
		return vehicleModelRepository.findAllModelIdsOrderByDesc();
	}

}
