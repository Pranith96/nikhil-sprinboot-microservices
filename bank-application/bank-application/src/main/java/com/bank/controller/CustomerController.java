package com.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.CustomerRequest;
import com.bank.dto.CustomerResponse;
import com.bank.entity.Account;
import com.bank.entity.Customer;
import com.bank.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	// https://localhost:9090/customer/save
	// To Save customer records - 201 CREATED
	@PostMapping("/save")
	public ResponseEntity<CustomerResponse> createCustomer(@RequestBody CustomerRequest customerRequest) {
		CustomerResponse response = customerService.createCustomer(customerRequest);
		if (response != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(CustomerResponse.builder().accountId(null)
				.customerId(null).message("Failed to create customer").build());
	}

	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> getAccountsForCustomer(@RequestParam("custId") long customerId,
			@RequestParam(value = "isActiveTag", required = false) String isActiveTag) {
		List<Account> response = customerService.getAccountsForCustomer(customerId, isActiveTag);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping
	public ResponseEntity<Customer> getCustomerInfo(@RequestParam("custId") long customerId) {
		Customer response = customerService.getCustomerInfo(customerId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/all")
	public ResponseEntity<List<Customer>> getAllCustomerInfo() {
		List<Customer> response = customerService.getAllCustomerInfo();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@DeleteMapping("/{custId}")
	public ResponseEntity<String> deletCustomerInfo(@PathVariable("custId") long customerId) {
		String response = customerService.deletCustomerInfo(customerId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
