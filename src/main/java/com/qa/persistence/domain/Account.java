package com.qa.persistence.domain;

import java.util.HashMap;
import java.util.Map;

public class Account{
	private String firstName;
	private String lastName;
	private Long accountNumber;
	
	public Account(String firstname, String lastname, Long accountNumber) {
	this.firstName = firstname;
	this.lastName = lastname;
	this.accountNumber = accountNumber;
	
	}
	
	public String getFirstName() {
		return firstName;
		
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		
	}
	public String getLastName() {
		return lastName;
		
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

}
