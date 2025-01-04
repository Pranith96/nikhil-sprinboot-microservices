package com.bank.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "account")
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer acccountId;

	@Column(unique = true)
	private Long accountNumber;

	private String accountStatus;

	@Enumerated(EnumType.STRING)
	private AccountType accountType;

	private BigDecimal accountBalance;

	private Long customerId;

	@CreationTimestamp
	private LocalDateTime createdAt;

	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public Integer getAcccountId() {
		return acccountId;
	}

	public void setAcccountId(Integer acccountId) {
		this.acccountId = acccountId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Account(Integer acccountId, Long accountNumber, String accountStatus, AccountType accountType,
			BigDecimal accountBalance, Long customerId, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.acccountId = acccountId;
		this.accountNumber = accountNumber;
		this.accountStatus = accountStatus;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.customerId = customerId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Account() {
	}

	@Override
	public String toString() {
		return "Account [acccountId=" + acccountId + ", accountNumber=" + accountNumber + ", accountStatus="
				+ accountStatus + ", accountType=" + accountType + ", accountBalance=" + accountBalance
				+ ", customerId=" + customerId + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}

}
