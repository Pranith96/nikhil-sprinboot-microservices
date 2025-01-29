package com.bank.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.dto.AccountRequest;
import com.bank.dto.AccountResponse;
import com.bank.entity.Account;
import com.bank.entity.Customer;
import com.bank.repository.AccountRepository;
import com.bank.util.BankUtil;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	BankUtil bankUitls;

	@Autowired
	CustomerService customerService;

	@Transactional
	@Override
	public String deleteAccountDetails(long accountId) {
		accountRepository.deleteByAccountNumber(accountId);
		return "Deleted successfully";
	}

	@Override
	public AccountResponse createAccount(AccountRequest accountCreateRequest, Long customerId) {
		Customer customer = customerService.getCustomerInfo(customerId);
		Account account = bankUitls.convertAccRequestToEntity(accountCreateRequest, customer.getCustomerId());
		Account accountResponse = saveAccount(account);
		if (accountResponse == null) {
			return null;
		}

		AccountResponse response = new AccountResponse();
		response.setAccountId(accountResponse.getAccountNumber());
		response.setMessage("Saved successfully");
		return response;
	}

	public Account saveAccount(Account account) {
		return accountRepository.save(account);
	}

	@Transactional
	@Override
	public String deactivateAccount(long accountNumber) {
		Account response = getAccountByAccountNumber(accountNumber);
		if (response.getAccountBalance().compareTo(BigDecimal.ZERO) == 1) {
			throw new RuntimeException("Account balance is greater than 0");
		}
		accountRepository.deactiveAccount(accountNumber, "INACTIVE");
		return "Deactivated successfully";
	}

	@Override
	public Account getAccountByAccountNumber(Long accountNumber) {
		Optional<Account> response = accountRepository.findByAccountNumber(accountNumber);
		if (!response.isPresent()) {
			throw new RuntimeException("Account number is not exsits");
		}
		return response.get();
	}
}
