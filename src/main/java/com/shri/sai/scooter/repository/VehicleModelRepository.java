package com.shri.sai.scooter.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.shri.sai.scooter.entity.VehicleModel;

@Repository
public interface VehicleModelRepository extends PagingAndSortingRepository<VehicleModel, Integer> {
	public VehicleModel findByModelId(Integer modelId);
	
	@Query(value="select max(modelId) from VehicleModel vm where vm.isActive = true")
	public Integer findAllModelIdsOrderByDesc();
}
