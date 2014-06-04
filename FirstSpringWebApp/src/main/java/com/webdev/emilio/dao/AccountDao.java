package com.webdev.emilio.dao;

import com.webdev.emilio.models.Account;

public interface AccountDao extends Dao<Account> {
	
	public Account getAccountByUsername(String username);		
	public void createAccount(Account account, String password);
	
}
