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
	@SequenceGenerator(name = "vehicle_model_seq", sequenceName = "vehicle_model_seq", initialValue = 10, allocationSize = 1)
	@Column(name = "model_id")
	private Integer modelId;
	@Column(name = "model_name")
	private String modelName;
	@Column(name = "model_desc")
	private String modelDesc;
	@Column(name = "is_active")
	private Boolean isActive;
	@Column(name = "speed")
	private String speed;
	@Column(name = "range")
	private String range;
	@Column(name = "charging_time")
	private String chargingTime;
	@Column(name = "payload")
	private String payload;
	@Column(name = "battery_size")
	private String batterySize;
	@Column(name = "motor_capacity")
	private String motorCapacity;
	@Column(name = "price")
	private String price;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_date")
	private String createdDate;
	@Column(name = "updated_by")
	private String updatedBy;
	@Column(name = "updated_date")
	private String updatedDate;
}
