package com.shri.sai.scooter.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.commons.compress.utils.IOUtils;
import com.shri.sai.scooter.entity.CustomerEnquiry;
import com.shri.sai.scooter.exporter.ExcelFileExporter;
import com.shri.sai.scooter.service.CustomerEnquiryService;

@Controller
@RequestMapping("/customer")
public class CustomerEnquiryController {

	@Autowired
	private CustomerEnquiryService customerEnquiryService;

	@GetMapping("/find/all")
	public String findAllCustomerEnquiriesForm(Model model) {
		model.addAttribute("enquries", customerEnquiryService.findAllEnquiries());
		return "customerinquery";
	}

	@GetMapping("/todays/inquiries")
	public String findTodaysCustomerEnquiriesForm(Model model) {
		model.addAttribute("todaysinquiries", customerEnquiryService.findAllTodaysEnquiries());
		return "todaysinquiries";
	}

	@GetMapping("/create/enquiry")
	public String createNewEnquiryForm(Model model) {
		CustomerEnquiry objCustomerEnquiry = new CustomerEnquiry();
		model.addAttribute("createinquiry", objCustomerEnquiry);
		return "createinquery";
	}

	@GetMapping("/update/enquiry/{inquiryId}")
	public String updateEnquiryForm(@PathVariable Integer inquiryId, Model model) {
		model.addAttribute("updateinquery", customerEnquiryService.getEnquiryByInquiryId(inquiryId));
		return "updateinquery";
	}

	@PostMapping(value = "/save/enquiry")
	public String createNewEnquiry(@ModelAttribute("createinquiry") CustomerEnquiry customerEnquiry) {
		String inquiryDate = getCurrentTimeUsingDate();
		customerEnquiry.setInquiryDate(inquiryDate);
		customerEnquiryService.createEnquiry(customerEnquiry);
		return "redirect:/customer/find/all";
	}

	@GetMapping("/download/customers_enquiries.xlsx")
	public void downloadCsv(HttpServletResponse response) throws IOException {
		List<CustomerEnquiry> findAllEnquiries = customerEnquiryService.findAllEnquiries();
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition", "attachment; filename=Customers Enquiries.xlsx");
		ByteArrayInputStream stream = ExcelFileExporter.customersEnquiriesListToExcelFile(findAllEnquiries);
		IOUtils.copy(stream, response.getOutputStream());
	}

	@PostMapping(value = "/update/enquiry/{inquiryId}")
	public String updateEnquiry(@PathVariable Integer inquiryId,
			@ModelAttribute("updateinquiry") CustomerEnquiry updateCustomerEnquiry, Model model) {
		CustomerEnquiry existingEnquiry = customerEnquiryService.getEnquiryByInquiryId(inquiryId);
		existingEnquiry.setInquiryId(inquiryId);
		existingEnquiry.setFirstName(updateCustomerEnquiry.getFirstName());
		existingEnquiry.setLastName(updateCustomerEnquiry.getLastName());
		existingEnquiry.setAddress(updateCustomerEnquiry.getAddress());
		existingEnquiry.setEmail1(updateCustomerEnquiry.getEmail1());
		existingEnquiry.setMobile1(updateCustomerEnquiry.getMobile1());
		existingEnquiry.setInterestedModel(updateCustomerEnquiry.getInterestedModel());
		String inquiryDate = getCurrentTimeUsingDate();
		existingEnquiry.setInquiryDate(inquiryDate);
		customerEnquiryService.updateEnquiry(existingEnquiry);
		return "redirect:/customer/find/all";
	}

	private String getCurrentTimeUsingDate() {
		Date date = new Date();
		String strDateFormat = "dd-MM-yyyy";
		DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		String formattedDate = dateFormat.format(date);
		return formattedDate;
	}
}
