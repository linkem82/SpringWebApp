package com.webdev.emilio.services;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	
	private static final Logger logger = LoggerFactory.getLogger(UserDetailsServiceAdapter.class);
	
	@Inject private UserDetailsDao dao;
	@Inject private AccountDao accountDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		String password = dao.getPasswordByUsername(username);
		Account account = accountDao.getAccountByUsername(username);
		if(account == null) {
			String message = "User with username: " + username + " not found.";
			throw new UsernameNotFoundException(message);
		} else if(account.getAuthorities().isEmpty()) {
			String message = "User " + username + " has no authority.";
			throw new UsernameNotFoundException(message);
		} else {
			UserDetailsAdapter userDetails = new UserDetailsAdapter(account);
			userDetails.setPassword(password);			
			logger.info("User authority: " + userDetails.getAuthorities().iterator().next().getAuthority());
			return userDetails;
		}
	}	

}
