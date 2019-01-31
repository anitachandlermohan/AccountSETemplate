package com.qa.persistence.repository;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Account;

import util.JSONUtil;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.List;

@Default
@Transactional(SUPPORTS)
public class AccountDatabaseRepository implements AccountRepository{
	
	
	@Inject
	private JSONUtil jsonutil;
	
	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	@Override
	public String getAllAccounts() {
		TypedQuery<Account> query = em.createQuery("SELECT a FROM Account a", Account.class);
		List<Account> accounts = query.getResultList();
		return jsonutil.getJSONForObject(accounts);
	}

	@Override
	@Transactional(REQUIRED)
	public String createAccount(String account) {
		Account accountObject = jsonutil.getObjectForJSON(account, Account.class);
		em.persist(accountObject);
		return "{\"message\": \"account added\"}";
		
		}

	@Override
	@Transactional(REQUIRED)
	public String deleteAccount(Long id) {
		Account account = em.find(Account.class, id);
		em.remove(account);
		return "{\"message\": \"account deleted\"}";
		
		
	}

	@Override
	@Transactional(REQUIRED)
	public String updateAccount(Long id, String account) {
		Account accountInDB = em.find(Account.class, id);
		Account accountUpdate = jsonutil.getObjectForJSON(account, Account.class);
		em.remove(accountInDB);
		em.persist(accountUpdate);
		return "{\"message\": \"account updated\"}";
		
	}

}
