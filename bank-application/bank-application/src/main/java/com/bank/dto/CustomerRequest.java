package com.bank.dto;

import com.bank.entity.Gender;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {
	private String name;
	private String emailId;
	private Integer age;
	private String mobileNumber;
	private Gender gender;
	private String userId;
	
	private AccountRequest accountRequest;
}
