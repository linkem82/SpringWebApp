package com.webdev.emilio.models;

public class Member {
	
	private String firstName;
	private String lastName;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String toString() {		
		return 	firstName + " " + lastName;
	}
	
	public boolean equals(Object object) {
		if(object == null)
			return false;		
		else if(this == object)
			return true;
		else if(object.getClass() != this.getClass())
			return false;
		else {
			Member member = (Member) object;
			if(member.firstName != this.firstName)
				return false;
			else if(member.lastName != this.lastName)
				return false;
			else
				return true;			
		}			
	}
	
	

}
