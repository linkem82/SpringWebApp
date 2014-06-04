package com.webdev.emilio.dao;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDetailsJdbcDao implements UserDetailsDao {
	
	private final static String PASSWORD_BY_USERNAME = "select password from accounts where username = ?";
	
	@Inject private JdbcTemplate template;
	
	@Override
	public String getPasswordByUsername(String username) {
		return template.queryForObject(PASSWORD_BY_USERNAME, new Object[]{username}, String.class);
	}
	
}
