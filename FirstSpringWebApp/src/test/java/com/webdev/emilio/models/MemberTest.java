package com.webdev.emilio.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class MemberTest {
	
	Member member1 = new Member();
	Member member2 = new Member();
	Member member3 = new Member();
	Member member4 = new Member();
	Member member5 = null;
	String string = "test";	
	
	@Test
	public void testEquals() {
		member1.setFirstName("Emilio");
		member1.setLastName("Sellitto");
		member2.setFirstName("Emilio");
		member2.setLastName("Sellitto");
		member3.setFirstName("Emilio");
		member3.setLastName("Romano");
		member4.setFirstName("Francesco");
		member4.setLastName("Sellitto");
		assertTrue(member1.equals(member2));
		assertFalse(member1.equals(member3));
		assertFalse(member1.equals(member4));
		assertFalse(member1.equals(member5));
		assertFalse(member1.equals(string));		
	}

}
