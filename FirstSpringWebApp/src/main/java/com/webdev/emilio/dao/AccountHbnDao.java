package com.webdev.emilio.dao;

import java.sql.SQLException;
import java.util.HashSet;

import javax.inject.Inject;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Repository;

import com.webdev.emilio.models.Account;
import com.webdev.emilio.models.Role;
import com.webdev.emilio.models.UserDetailsAdapter;

@Repository
public class AccountHbnDao extends AbstractHbnDao<Account> implements AccountDao {
	
	private static final Logger logger = LoggerFactory.getLogger(AccountHbnDao.class); 	
	private static final String UPDATE_ACCOUNT_QUERY = "update accounts set password = ? where username = ?";
	
	@Inject private  JdbcTemplate template;
	@Inject private ShaPasswordEncoder encoder;
	@Inject private SaltSource saltSource;

	@Override
	public Account getAccountByUsername(String username) {
		Query query = super.getSession().getNamedQuery("findAccountByUserName");
		query.setParameter("username", username);		
		return (Account)query.uniqueResult();		
	}

	@Override
	public void createAccount(Account account, String password) {
		this.addUserRole(account);
		super.create(account);
		super.getSession().flush();
		Object salt = saltSource.getSalt(new UserDetailsAdapter(account));
		String encodedPassword = encoder.encodePassword(password, salt);
		logger.info("username: " + account.getUsername() + " password: " + password);
		int res = template.update(UPDATE_ACCOUNT_QUERY, encodedPassword, account.getUsername());		
		logger.info("Number of rows updated: " + res);		
	}
	
	private void addUserRole(Account account) {
		Role userRole = (Role) super.getSession().get(Role.class, new Long(2));
		account.setAuthorities(new HashSet());
		account.getAuthorities().add(userRole);
	};
	
}
