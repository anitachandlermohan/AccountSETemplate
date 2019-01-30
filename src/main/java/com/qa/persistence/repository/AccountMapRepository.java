package com.qa.persistence.repository;


import java.util.HashMap;

import java.util.Map;

import com.qa.persistence.domain.Account;

import util.JSONUtil;

public class AccountMapRepository implements AccountRepository{
	JSONUtil jsonutil = new JSONUtil();
	Map<Long, Account> accountMap = new HashMap<>();
	
	
	public String getAllAccounts() {
		String accounts = "";
		for(Long accountNumber : accountMap.keySet()) {
			accounts += accountMap.get(accountNumber).toString();
			 accounts += "\n";
		}
		return accounts;
	}

	public String createAccount(String account) {

		
		Account acc = jsonutil.getObjectForJSON(account, Account.class);
		
		accountMap.put(acc.getAccountNumber(), acc); 
		
		
		return "WELL DONE";
	}

	public String deleteAccount(Long id) {
		try {
		accountMap.remove(id);
		return "removed " + id;
		}
		catch (Exception idNotFound){
			return "No account with this ID";
		}
	}

	public String updateAccount(Long id, String account) {
		Account acc = jsonutil.getObjectForJSON(account,Account.class);
		accountMap.put(id, acc);
		return "updated " + id;
		
	}
	public Account getAccountByID(Long id) {
		
		return accountMap.get(id);
		
		
		
	}
	
	public int getRepoSize() {
		return accountMap.size();
	}
	
	public int firstNameCount(String name) {
		int count = 0;
		for(Account acc: accountMap.values()) {
			
			if(acc.getFirstName().equals(name)) {
			
			count++;
			}
				
		}
		return count;
	}

}
