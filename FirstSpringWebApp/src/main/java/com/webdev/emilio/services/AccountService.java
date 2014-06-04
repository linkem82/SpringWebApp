package com.webdev.emilio.services;

import org.springframework.validation.Errors;

import com.webdev.emilio.models.Account;

public interface AccountService {
	public boolean registerAccount(Account account, String password, Errors errors);
}
