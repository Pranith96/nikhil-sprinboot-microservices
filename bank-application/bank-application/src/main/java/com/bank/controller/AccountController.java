package com.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
