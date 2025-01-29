package com.bank.service;

import com.bank.dto.AccountRequest;
import com.bank.dto.AccountResponse;
import com.bank.entity.Account;

public interface AccountService {

	String deleteAccountDetails(long accountId);

	AccountResponse createAccount(AccountRequest accountCreateRequest, Long customerId);

	String deactivateAccount(long accountId);

	Account getAccountByAccountNumber(Long accountId);

}
