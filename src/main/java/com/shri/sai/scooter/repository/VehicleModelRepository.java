package com.shri.sai.scooter.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.shri.sai.scooter.entity.VehicleModel;

@Repository
public interface VehicleModelRepository extends PagingAndSortingRepository<VehicleModel, Integer> {

}
