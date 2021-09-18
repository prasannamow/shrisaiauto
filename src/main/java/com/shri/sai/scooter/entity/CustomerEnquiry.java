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
@Table(name = "customer_inquiries")
public class CustomerEnquiry {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_inquiries_seq")
	@SequenceGenerator(name = "customer_inquiries_seq", sequenceName = "customer_inquiries_seq", initialValue = 1, allocationSize = 1)
	@Column(name = "inquiry_id")
	private Integer inquiryId;
	@Column(name = "inquiry_date")
	private String inquiryDate;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "mobile1")
	private String mobile1;
	@Column(name = "mobile2")
	private String mobile2;
	@Column(name = "email1")
	private String email1;
	@Column(name = "address")
	private String address;
	@Column(name = "reference_by")
	private String referenceBy;
	@Column(name = "interested_model")
	private String interestedModel;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_date")
	private String createdDate;
	@Column(name = "updated_by")
	private String updatedBy;
	@Column(name = "updated_date")
	private String updatedDate;
	@Column(name = "is_active")
	private Boolean isActive;
	
}
