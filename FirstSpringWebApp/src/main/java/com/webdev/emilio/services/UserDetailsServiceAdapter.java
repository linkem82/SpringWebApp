package com.webdev.emilio.services;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.webdev.emilio.dao.AccountDao;
import com.webdev.emilio.dao.UserDetailsDao;
import com.webdev.emilio.models.Account;
import com.webdev.emilio.models.UserDetailsAdapter;

@Service("userDetailsService")
@Transactional(readOnly=true)
public class UserDetailsServiceAdapter implements UserDetailsService {
	
	@Inject private UserDetailsDao dao;
	@Inject private AccountDao accountDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		String password = dao.getPasswordByUsername(username);
		Account account = accountDao.getAccountByUsername(username);
		if(account == null) {
			String message = "User with username: " + username + " not found.";
			throw new UsernameNotFoundException(message);
		} else if(account.getAuthorities() == null) {
			String message = "User " + username + " has no authority.";
			throw new UsernameNotFoundException(message);
		} else {
			UserDetailsAdapter userDetails = new UserDetailsAdapter();
			userDetails.setPassword(password);
			userDetails.setAccount(account);
			return userDetails;
		}
	}	

}
