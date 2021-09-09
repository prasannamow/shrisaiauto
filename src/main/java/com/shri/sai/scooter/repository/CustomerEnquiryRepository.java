package com.shri.sai.scooter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.shri.sai.scooter.entity.CustomerEnquiry;

@Repository
public interface CustomerEnquiryRepository extends PagingAndSortingRepository<CustomerEnquiry, Integer> {
	public CustomerEnquiry findByInquiryId(Integer inquiryId);

	public List<CustomerEnquiry> findByOrderByInquiryIdAsc();

	@Query("SELECT CI FROM CustomerEnquiry CI WHERE TO_DATE(CI.inquiryDate,'dd-MM-yyyy') >= CURRENT_DATE")
	public List<CustomerEnquiry> findTodaysInquiries();
}
