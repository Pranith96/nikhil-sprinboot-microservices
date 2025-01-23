package com.bank.service;

import java.util.List;

import com.bank.dto.CustomerRequest;
import com.bank.dto.CustomerResponse;
import com.bank.entity.Account;
import com.bank.entity.Customer;

public interface CustomerService {

	CustomerResponse createCustomer(CustomerRequest customer);

	List<Account> getAccountsForCustomer(long customerId);

	Customer getCustomerInfo(long customerId);

	List<Customer> getAllCustomerInfo();

}
