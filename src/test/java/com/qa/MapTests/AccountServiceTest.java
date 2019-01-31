package com.qa.MapTests;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountMapRepository;

import util.JSONUtil;

public class AccountServiceTest {

	private AccountMapRepository repo;
	private JSONUtil jsonutil;
	private Account catdogsaccount;
	private String catdogAccountString;
	private Account edsaccount;
	private String edsAccountString;
	private Account bob1sAccount;
	private String bob1sAccountString;
	private Account bob2sAccount;
	private String bob2sAccountString;
	private Account bob3sAccount;
	
	
	@Before 
	public void setup() {
		jsonutil = new JSONUtil();
		repo = new AccountMapRepository();
		catdogsaccount = new Account("Cat", "Dog", 1234L);
		catdogAccountString = jsonutil.getJSONForObject(catdogsaccount);
		edsaccount = new Account("Ed", "Eddy", 12345L);
		edsAccountString = jsonutil.getJSONForObject(edsaccount);
		bob1sAccount = new Account("Bob", "Bobford", 2333L);
		bob1sAccountString = jsonutil.getJSONForObject(bob1sAccount);
		bob2sAccount = new Account("Bob", "Bobbington", 333L);
		bob2sAccountString = jsonutil.getJSONForObject(bob2sAccount);
		bob3sAccount = new Account("Bob", "Bobton", 445L);
		
		
	}
	@Ignore
	@Test
	public void addAccountTest() {
		
	
		repo.createAccount(catdogAccountString);
		Account account = repo.getAccountByID(catdogsaccount.getAccountNumber());
		assertEquals("account not added", account.getAccountNumber(), catdogsaccount.getAccountNumber());
		
		
		
	}
	@Ignore
	@Test
	public void add2AccountTest() {
		

		repo.createAccount(catdogAccountString);
		repo.createAccount(edsAccountString);
		assertEquals("accounts not added", 2, repo.getRepoSize());
	}
	@Ignore
	@Test
	public void removeAccountTest() {
		repo.createAccount(edsAccountString);
		repo.deleteAccount(edsaccount.getAccountNumber());
		assertEquals("account not removed", 0, repo.getRepoSize());
		
		
		 
	}
	@Ignore
	@Test
	public void remove2AccountTest() {
		
		repo.createAccount(catdogAccountString);
		repo.createAccount(edsAccountString);
		repo.deleteAccount(catdogsaccount.getAccountNumber());
		repo.deleteAccount(edsaccount.getAccountNumber());
		assertEquals("accounts not removed", 0, repo.getRepoSize());
		
		
	}
	@Ignore
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
	@Ignore
	@Test
	public void getCountForFirstNamesInAccountWhenZeroOccurances() {
		assertEquals("count is not 0", 0, repo.firstNameCount("Bob"));
		
	}
	@Ignore
	@Test
	public void getCountForFirstNamesInAccountWhenOne() {
		repo.createAccount(edsAccountString);
		repo.createAccount(bob1sAccountString);
		assertEquals("count should be 1", 1, repo.firstNameCount("Bob"));
		
	}
	@Ignore
	@Test
	public void getCountForFirstNamesInAccountWhenMult() {
		repo.createAccount(bob1sAccountString);
		repo.createAccount(bob2sAccountString);
		repo.createAccount(catdogAccountString);
		assertEquals("count should be 2", 2, repo.firstNameCount("Bob"));
	}

}
