package com.shri.sai.scooter.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shri.sai.scooter.entity.CustomerEnquiry;
import com.shri.sai.scooter.repository.CustomerEnquiryRepository;
import com.shri.sai.scooter.service.CustomerEnquiryService;

@Service
public class CustomerEnquiryServiceImpl implements CustomerEnquiryService {

	@Autowired
	private CustomerEnquiryRepository customerEnquiryRepository;

	@Override
	public CustomerEnquiry createEnquiry(CustomerEnquiry customerEnquiry) {
		return customerEnquiryRepository.save(customerEnquiry);
	}

	@Override
	public List<CustomerEnquiry> findAllEnquiries() {
		return (List<CustomerEnquiry>) customerEnquiryRepository.findAllInquiries();
	}

	@Override
	public CustomerEnquiry updateEnquiry(CustomerEnquiry customerEnquiry) {
		return customerEnquiryRepository.save(customerEnquiry);
	}

	@Override
	public CustomerEnquiry getEnquiryByInquiryId(Integer inquiryId) {
		return customerEnquiryRepository.findByInquiryId(inquiryId);
	}

	@Override
	public List<CustomerEnquiry> findAllTodaysEnquiries() {
		return customerEnquiryRepository.findTodaysInquiries();
	}

	@Override
	public Page<CustomerEnquiry> findAllPaginatedEnquiries(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber -1, pageSize);
		return this.customerEnquiryRepository.findAll(pageable);
	}

}
