package com.bank.util;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.bank.dto.AccountRequest;
import com.bank.dto.CustomerRequest;
import com.bank.entity.Account;
import com.bank.entity.Customer;

@Component
public class BankUtil {

	public Account convertAccRequestToEntity(AccountRequest accountRequest, Long customerId) {
		Account account = new Account();
		account.setAccountBalance(accountRequest.getAccountBalance());
		account.setAccountNumber(generateRandomAccountNum());
		account.setAccountStatus("ACTIVE");
		account.setAccountType(accountRequest.getAccountType());
		account.setCustomerId(customerId);
		return account;
	}

	private Long generateRandomAccountNum() {
		Random random = new Random();
		long accountNum = random.nextLong(5555, 99999);
		return accountNum;
	}

	public Customer convertCustRequestToEntity(CustomerRequest customerRequest) {
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
}
