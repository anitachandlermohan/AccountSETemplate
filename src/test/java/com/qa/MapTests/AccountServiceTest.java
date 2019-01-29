package com.qa.MapTests;

import static org.junit.Assert.*;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;

import util.JSONUtil;

public class AccountServiceTest {
	AccountMapRepository repo ;
	JSONUtil jsonutil = new JSONUtil();
	Account catdogsaccount = new Account("Cat", "Dog", 1234L);
	String catdogAccountString = jsonutil.getJSONForObject(catdogsaccount);
	Account edsaccount = new Account("Ed", "Eddy", 12345L);
	String edsAccountString = jsonutil.getJSONForObject(edsaccount);

	@Before 
	public void setup() {
		
		repo = new AccountMapRepository();
		
		
		
	
	}
	
	@Test
	public void addAccountTest() {
		
	
		repo.createAccount(catdogAccountString);
		Account account = repo.getAccountByID(catdogsaccount.getAccountNumber());
		assertEquals("account not added", account.getAccountNumber(), catdogsaccount.getAccountNumber());
		
		
		
	}
	
	@Test
	public void add2AccountTest() {
		

		repo.createAccount(catdogAccountString);
		repo.createAccount(edsAccountString);
		assertEquals("accounts not added", 2, repo.getRepoSize());
	}

	@Test
	public void removeAccountTest() {
		repo.createAccount(edsAccountString);
		repo.deleteAccount(edsaccount.getAccountNumber());
		assertEquals("account not removed", repo.getRepoSize(), 0);
		
		
		 
	}
	
	@Test
	public void remove2AccountTest() {
		
		repo.createAccount(catdogAccountString);
		repo.createAccount(edsAccountString);
		repo.deleteAccount(catdogsaccount.getAccountNumber());
		repo.deleteAccount(edsaccount.getAccountNumber());
		assertEquals("accounts not removed", 0, repo.getRepoSize());
		
		
	}
	
	@Test
	public void remove2AccountTestAnd1ThatDoesntExist() {
		
		repo.createAccount(catdogAccountString);
		repo.createAccount(edsAccountString);
		repo.deleteAccount(catdogsaccount.getAccountNumber());
		repo.deleteAccount(edsaccount.getAccountNumber());
		repo.deleteAccount(2234L);
		assertEquals("accounts not removed", 0, repo.getRepoSize());
		
	}
	
	@Test
	public void accountConversionToJSONTestWithEmptyMap() {
	
	}
	
	@Test
	public void accountConversionToJSONTestEmptyMapWithConversion() {
	
	}

	@Test
	public void accountConversionToJSONTest() {
		
	}

	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		
	}
	
	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		
	}

	@Test
	public void getCountForFirstNamesInAccountWhenMult() {
		
	}

}
