package com.bank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Transactional
	@Override
	public String deleteAccountDetails(long accountId) {
		accountRepository.deleteByAccountNumber(accountId);
		return "Deleted successfully";
	}
}
