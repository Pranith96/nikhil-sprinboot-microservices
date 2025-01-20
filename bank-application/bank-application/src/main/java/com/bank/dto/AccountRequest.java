package com.bank.dto;

import java.math.BigDecimal;

import com.bank.entity.AccountType;

import lombok.Data;

@Data
public class AccountRequest {

	private AccountType accountType;
	private BigDecimal accountBalance;
}
