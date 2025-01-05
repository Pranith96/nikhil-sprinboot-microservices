package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.entity.Customer;
import com.bank.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public String createCustomer(Customer customer) {
		Customer customerResponse = customerRepository.save(customer);
		if (customerResponse == null) {
			return null;
		}
		return "Customer Created Successfully";
	}
}
