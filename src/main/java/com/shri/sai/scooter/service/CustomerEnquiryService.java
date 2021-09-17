package com.shri.sai.scooter.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.shri.sai.scooter.entity.CustomerEnquiry;

public interface CustomerEnquiryService {

	public CustomerEnquiry createEnquiry(CustomerEnquiry customerEnquiry);

	public List<CustomerEnquiry> findAllEnquiries();

	public Page<CustomerEnquiry> findAllPaginatedEnquiries(int pageNumber, int pageSize);

	public CustomerEnquiry getEnquiryByInquiryId(Integer inquiryId);

	public CustomerEnquiry updateEnquiry(CustomerEnquiry customerEnquiry);

	public List<CustomerEnquiry> findAllTodaysEnquiries();

}
