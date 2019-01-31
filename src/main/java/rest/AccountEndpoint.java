package rest;

import javax.inject.Inject;
import javax.ws.rs.*;

import service.AccountService;

@Path("/account")
public class AccountEndpoint {
	@Inject
	private AccountService service;
	
	
	@Path("/allAccounts")
	@GET
	@Produces({"application/json"})
	public String getAllAccounts() {
		return service.getAllAccounts();
	}
	
	@Path("/createAccount")
	@POST
	@Produces({"application/json"})
	public String createAccount(String account) {
		return service.createAccount(account);
	}
	
	
	@Path("/updateAccount/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateAccount(@PathParam("id")Long id, String account) {
		return service.updateAccount(id, account);
	}

	@Path("/deleteAccount/{id}")
	@DELETE
	@Produces({"application/json"})
	public String deleteAccount(@PathParam("id")Long id) {
		return service.deleteAccount(id);
		
	}
	

}
