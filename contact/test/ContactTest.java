package com.contact.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import com.contact.Contact;

public class ContactTest {
	@Test
	void testValidContactCreation() {
		Contact contact = new Contact("12345", "Bob", "Ross", "1234567890", "123 Street, Dayton, OH, 44256");
		assertEquals("12345", contact.getContactId());
	}
	
	@Test
	void testInvalidContactId() {
		try {
			new Contact(null, "Bob", "Ross", "1234567890", "123 Street, Dayton, OH, 44256");
		}
		catch(Exception e) {
			// success
		}
		
		try {
			new Contact("123456789123456789", "Bob", "Ross", "1234567890", "123 Street, Dayton, OH, 44256");
		}
		catch(Exception e) {
			// success
		}
	}
	
	@Test
	void testInvalidFirstName() {
		try {
			new Contact("12345", "Booooooooooooooooooooooooooooob", "Ross", "1234567890", "123 Street, Dayton, OH, 44256");
		}
		catch(Exception e) {
			// success
		}
		
		try {
			new Contact("12345", null, "Ross", "1234567890", "123 Street, Dayton, OH, 44256");
		}
		catch(Exception e) {
			// success
		}
	}
	
	@Test
	void testInvalidLastName() {
		try {
			new Contact("12345", "Bob", "Roooooooooooooooosssssssssssss", "1234567890", "123 Street, Dayton, OH, 44256");
		}
		catch(Exception e) {
			// success
		}
		
		try {
			new Contact("12345", "Bob", null, "1234567890", "123 Street, Dayton, OH, 44256");
		}
		catch(Exception e) {
			// success
		}
	}
	
	@Test
	void testInvalidPhoneNumber() {
		try {
			new Contact("12345", "Bob", "Ross", "1234", "123 Street, Dayton, OH, 44256");
		}
		catch(Exception e) {
			// success
		}
		
		try {
			new Contact("12345", "Bob", "Ross", null, "123 Street, Dayton, OH, 44256");
		}
		catch(Exception e) {
			// success
		}
		
		try {
			new Contact("12345", "Bob", "Ross", "123456789123456789", "123 Street, Dayton, OH, 44256");
		}
		catch(Exception e) {
			// success
		}
	}
	
	@Test
	void testInvalidAddress() {
		try {
			new Contact("12345", "Bob", "Ross", "1234567890", null);
		}
		catch(Exception e) {
			// success
		}
		
		try {
			new Contact("12345", "Bob", "Ross", "1234567890", "111111111111111111111111111111111111111111111111111123 Street, Dayton, OH, 44256");
		}
		catch(Exception e) {
			// success
		}
	}
	
	@Test
	void testGetters() {
		Contact contact = new Contact("12334", "Bob", "Ross", "1234567890", "123 Street, Dayton, OH, 44256");
		assertEquals("Bob", contact.getFirstName());
		assertEquals("Ross", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("123 Street, Dayton, OH, 44256", contact.getAddress());
	}
	
	@Test
	void testSettersValidateInput() {
		Contact contact = new Contact("12334", "Bob", "Ross", "1234567890", "123 Street, Dayton, OH, 44256");
		
		assertThrows(IllegalArgumentException.class, () -> contact.setFirstName(null));
		assertThrows(IllegalArgumentException.class, () -> contact.setFirstName("Boooooooooooooooooooooooooooooooob"));
		assertThrows(IllegalArgumentException.class, () -> contact.setLastName(null));
		assertThrows(IllegalArgumentException.class, () -> contact.setLastName("Rooooooooooooooooooosssssssssssssssss"));
		assertThrows(IllegalArgumentException.class, () -> contact.setPhone(null));
		assertThrows(IllegalArgumentException.class, () -> contact.setPhone("111111111111222222222333333444444555555555"));
		assertThrows(IllegalArgumentException.class, () -> contact.setPhone("12345"));
		assertThrows(IllegalArgumentException.class, () -> contact.setAddress("I live on the moon where the land is made of cheese. I want not for water for I am sustained by the cheese's moisture."));
		assertThrows(IllegalArgumentException.class, () -> contact.setAddress(null));
	}
	
	@Test
	void testSetters() {
		Contact contact = new Contact("12334", "Gomez", "Addams", "1234567899", "0001 Cemetery Lane");
		contact.setFirstName("Bob");
		contact.setLastName("Ross");
		contact.setPhone("1234567890");
		contact.setAddress("123 Street, Dayton, OH, 44256");
		assertEquals("Bob", contact.getFirstName());
		assertEquals("Ross", contact.getLastName());
		assertEquals("1234567890", contact.getPhone());
		assertEquals("123 Street, Dayton, OH, 44256", contact.getAddress());
	}

}
