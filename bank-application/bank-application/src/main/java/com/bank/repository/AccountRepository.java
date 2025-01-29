package com.bank.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bank.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

	List<Account> findByCustomerId(long customerId);

	void deleteByCustomerId(long customerId);

	void deleteByAccountNumber(long accountId);

	Optional<Account> findByAccountNumber(long accountId);

	@Modifying
	@Query("Update Account acc set acc.accountStatus=:accountStatus where acc.accountNumber=:accountNumber")
	void deactiveAccount(long accountNumber, String accountStatus);

}
