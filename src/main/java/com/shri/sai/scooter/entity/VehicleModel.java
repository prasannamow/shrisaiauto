package com.shri.sai.scooter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "vehicle_model")
public class VehicleModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_model_seq")
	@SequenceGenerator(name = "vehicle_model_seq", sequenceName = "vehicle_model_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "model_id")
	private Integer modelId;
	@Column(name = "model_name")
	private String modelName;
	@Column(name = "model_desc")
	private String modelDesc;
	@Column(name = "is_active")
	private Boolean isActive;

}
