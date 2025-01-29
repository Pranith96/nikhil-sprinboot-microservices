package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank.dto.AccountRequest;
import com.bank.dto.AccountResponse;
import com.bank.entity.Account;
import com.bank.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	AccountService accountService;

	@DeleteMapping("/{accountId}")
	public ResponseEntity<String> deleteAccountDetails(@PathVariable("accountId") long accountId) {
		String response = accountService.deleteAccountDetails(accountId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping("/save")
	public ResponseEntity<AccountResponse> createAccount(@RequestBody AccountRequest accountCreateRequest,
			@RequestParam("custId") Long customerId) {
		AccountResponse response = accountService.createAccount(accountCreateRequest, customerId);
		if (response != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(AccountResponse.builder().accountId(null).message("Failed to create Account").build());
	}

	@PutMapping("/deactive/{accountNumber}")
	public ResponseEntity<String> deactivateAccount(@PathVariable("accountNumber") long accountNumber) {
		String response = accountService.deactivateAccount(accountNumber);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("/{accountId}")
	public ResponseEntity<Account> getAccountDetails(@PathVariable("accountId") long accountId) {
		Account response = accountService.getAccountByAccountNumber(accountId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
