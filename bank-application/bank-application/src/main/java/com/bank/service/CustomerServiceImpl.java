package com.bank.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dto.AccountRequest;
import com.bank.dto.CustomerRequest;
import com.bank.dto.CustomerResponse;
import com.bank.entity.Account;
import com.bank.entity.Customer;
import com.bank.repository.AccountRepository;
import com.bank.repository.CustomerRepository;

import io.micrometer.common.util.StringUtils;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	AccountRepository accountRepository;

	@Transactional
	@Override
	public CustomerResponse createCustomer(CustomerRequest customerRequest) {

		Customer customer = convertCustRequestToEntity(customerRequest);
		Customer customerResponse = customerRepository.save(customer);
		Account account = convertAccRequestToEntity(customerRequest.getAccountRequest(),
				customerResponse.getCustomerId());
		Account accountResponse = accountRepository.save(account);
		if (customerResponse == null || accountResponse == null) {
			return null;
		}

		CustomerResponse response = new CustomerResponse();
		response.setAccountId(accountResponse.getAccountNumber());
		response.setCustomerId(customerResponse.getCustomerId());
		response.setMessage("Customer Created Successfully");
		return response;
	}

	private Account convertAccRequestToEntity(AccountRequest accountRequest, Long customerId) {
		Account account = new Account();
		account.setAccountBalance(accountRequest.getAccountBalance());
		account.setAccountNumber(generateRandomAccountNum());
		account.setAccountStatus("ACTIVE");
		account.setAccountType(accountRequest.getAccountType());
		account.setCustomerId(customerId);
		return account;
	}

	private Customer convertCustRequestToEntity(CustomerRequest customerRequest) {
		Customer customer = new Customer();
		customer.setName(customerRequest.getName());
		customer.setAge(customerRequest.getAge());
		customer.setCustomerId(generateRandomCustomId());
		customer.setEmailId(customerRequest.getEmailId());
		customer.setGender(customerRequest.getGender());
		customer.setMobileNumber(customerRequest.getMobileNumber());
		customer.setStatus("ACTIVE");
		customer.setUserId(customerRequest.getUserId());
		return customer;
	}

	private Long generateRandomCustomId() {
		Random random = new Random();
		long customerId = random.nextLong(1000, 999999);
		return customerId;
	}

	private Long generateRandomAccountNum() {
		Random random = new Random();
		long accountNum = random.nextLong(5555, 99999);
		return accountNum;
	}

	@Override
	public List<Account> getAccountsForCustomer(long customerId, String isActiveTag) {
		List<Account> response = accountRepository.findByCustomerId(customerId);
		if (response == null) {
			throw new RuntimeException("Data is not found for customerId");
		}

		if (StringUtils.isNotBlank(isActiveTag) && "Y".equals(isActiveTag)) {
			return response.stream().filter(x -> x.getAccountStatus().equals("ACTIVE")).collect(Collectors.toList());
		}
		return response;
	}

	@Override
	public Customer getCustomerInfo(long customerId) {
		Optional<Customer> response = customerRepository.findByCustomerId(customerId);
		if (!response.isPresent()) {
			throw new RuntimeException("Data is not found for customerId");
		}
		return response.get();
	}

	@Override
	public List<Customer> getAllCustomerInfo() {
		List<Customer> response = customerRepository.findAll();
		if (response == null) {
			throw new RuntimeException("Data is empty");
		}
		return response;
	}

	@Transactional
	@Override
	public String deletCustomerInfo(long customerId) {
		customerRepository.deleteByCustomerId(customerId);
		accountRepository.deleteByCustomerId(customerId);
		return "Deleted successfully";
	}
}
