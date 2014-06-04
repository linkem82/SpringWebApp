package com.webdev.emilio.services;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import com.webdev.emilio.dao.AccountDao;
import com.webdev.emilio.models.Account;

@Service
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {
	
	@Inject private AccountDao accountDao;
	
	@Override
	@Transactional(readOnly = false)
	public boolean registerAccount(Account account, String password, Errors errors) {
		validateUsername(account, errors);
		boolean validate = !errors.hasErrors();
		if(validate) {
			accountDao.createAccount(account, password);
		}
		return validate;
	}
	
	private void validateUsername(Account account, Errors errors) {
		if(accountDao.getAccountByUsername(account.getUsername()) != null) {
			errors.rejectValue("username", "error.duplicate",new String[] {account.getUsername()}, null);
		}
	}

}
