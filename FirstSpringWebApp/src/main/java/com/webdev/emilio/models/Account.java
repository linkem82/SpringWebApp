package com.webdev.emilio.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "accounts")
@NamedQuery(name = "findAccountByUserName",
			query = "select a from Account a where a.username = :username")
public class Account {
	
	private Long id;
	private String username;
	private String firstName;
	private String lastName;
	private String email;
	private boolean marketingOk = true;
	private boolean acceptTerm = false;
	private boolean enabled = true;
	private Date dateCreated;
	private Set<Role> authorities;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="ACCOUNT_SEQ")
	@SequenceGenerator(name="ACCOUNT_SEQ", sequenceName="ACCOUNT_SEQ", allocationSize=1)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@NotNull
	@Size(min=1, max=50)
	@Column(name = "username")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@NotNull
	@Size(min=1, max=50)
	@Column(name = "first_name")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@NotNull
	@Size(min=1, max=50)
	@Column(name = "last_name")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@NotNull
	@Size(min=1, max=50)
	@Column(name = "email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@NotNull
	@Column(name = "marketing_ok")
	public boolean isMarketingOk() {
		return marketingOk;
	}	
	public void setMarketingOk(boolean marketingOk) {
		this.marketingOk = marketingOk;
	}
	@NotNull
	@Column(name = "accept_terms")
	public boolean isAcceptTerm() {
		return acceptTerm;
	}
	public void setAcceptTerm(boolean acceptTerm) {
		this.acceptTerm = acceptTerm;
	}
	@NotNull
	@Column(name = "enabled")
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}	
	@Column(name = "date_created")
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	@Transient
	public String  getFullName() {
		return this.firstName + this.lastName;
	}
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable
	  (
	      name="ACCOUNTS_ROLES",
	      joinColumns={ @JoinColumn(name="ACCOUNT_ID", referencedColumnName="ID") },
	      inverseJoinColumns={ @JoinColumn(name="ROLE_ID", referencedColumnName="ID") }
	  )
	public Set<Role> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<Role> authorities) {
		this.authorities = authorities;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Account other = (Account) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", username=" + username + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email
				+ ", marketingOk=" + marketingOk + ", acceptTerm=" + acceptTerm
				+ ", enabled=" + enabled + "]";
	}	

}
