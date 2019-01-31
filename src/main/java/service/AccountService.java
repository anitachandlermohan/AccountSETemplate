package service;

public interface AccountService {
	public String getAllAccounts() ;
	
	public String createAccount(String account);
	
	public String deleteAccount(Long id);
	
	public String updateAccount(Long id, String account);

}
