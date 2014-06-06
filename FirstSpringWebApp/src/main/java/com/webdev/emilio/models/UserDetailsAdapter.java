package com.webdev.emilio.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsAdapter implements UserDetails {
	
	private Account account;
	private String password;	
	
	public UserDetailsAdapter(Account account) {
		this.account = account;
	}
	
	@Override
	public String getUsername() {
		return account.getUsername();
	}
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	@Override
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Long getId() {
		return account.getId();
	}
	
	public String getFirstName() {
		return account.getFirstName();
	}
	
	public String getLastName() {
		return account.getLastName();
	}	
	
	public String getEmail() {
		return account.getEmail();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Role> rolesSet = account.getAuthorities(); 
		Set<GrantedAuthority> authoritiesSet = new HashSet<GrantedAuthority>();
		for(Role role: rolesSet) {
			authoritiesSet.add(new GrantedAuthorityImpl(role.getName()));
		}
		return authoritiesSet;
	}		

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return account.isEnabled();
	}

}
