package com.webdev.emilio.models;

import javax.validation.constraints.*;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.ScriptAssert;

@ScriptAssert(
		lang = "javascript",
		script = "_this.confirmPassword.equals(_this.password)",
		message = "account.password.mismatch.message")
public class AccountForm {

	private String username, 
	password, 
	confirmPassword,	
	firstName,
	lastName,
	email;
	
	private boolean marketingOk = true;
	private boolean acceptTerms = false;
	
	@NotNull
	@Size(min=1, max=50)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}	
	@NotNull
	@Size(min=6, max=50)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	@Size(min=1, max=50)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Size(min=1, max=50)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Email
	@Size(min=1, max=50)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isMarketingOk() {
		return marketingOk;
	}
	public void setMarketingOk(boolean marketingOk) {
		this.marketingOk = marketingOk;
	}
	@AssertTrue(message="{account.acceptTerms.assertTrue.message}")
	public boolean isAcceptTerms() {
		return acceptTerms;
	}
	public void setAcceptTerms(boolean acceptTerms) {
		this.acceptTerms = acceptTerms;
	}
	@Override
	public String toString() {
		return "AccountForm [username=" + username
				+ ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email
				+ ", marketingOk=" + marketingOk + ", acceptTerms="
				+ acceptTerms + ", password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountForm other = (AccountForm) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}
