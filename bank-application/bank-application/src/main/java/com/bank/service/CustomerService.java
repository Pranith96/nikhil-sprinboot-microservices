package com.bank.service;

import com.bank.dto.CustomerRequest;
import com.bank.dto.CustomerResponse;

public interface CustomerService {

	CustomerResponse createCustomer(CustomerRequest customer);

}
