package service;

import javax.inject.Inject;

import com.qa.persistence.domain.Account;
import com.qa.persistence.repository.AccountRepository;

import util.JSONUtil;

public class AccountServiceImpl implements AccountService{
	
	@Inject
	private AccountRepository repo;
	
	@Inject
	private JSONUtil jsonutil;

	@Override
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}

	@Override
	public String createAccount(String account) {
		Account newAccount = jsonutil.getObjectForJSON(account, Account.class);
		if(newAccount.getAccountNumber().equals(9)) {
			return"{\"message\": \"account is blocked\"}";
		}
		else {	
		return repo.createAccount(account);
		}
	}

	@Override
	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);
	}
	
	@Override
	public String updateAccount(Long id, String account) {
		return repo.updateAccount(id, account);
		
	}

}
