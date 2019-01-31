package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Account{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column
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
