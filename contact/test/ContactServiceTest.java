package com.contact.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.contact.Contact;
import com.contact.ContactService;

public class ContactServiceTest {
	private ContactService service;
	
	@BeforeEach
	void setUp() {
		service = new ContactService();
		service.addContact(new Contact("12345", "Bob", "Ross", "1234567890", "123 Street, Dayton, OH, 44256"));
	}
	
	@Test
	void testAddContactSuccess() {
		assertTrue(service.addContact(new Contact("12346", "Ellen", "Ripley", "1234568888", "Space")));
	}
	
	@Test
	void testAddContactDuplicateIDFail() {
		assertFalse(service.addContact(new Contact("12345", "Phil", "Roberts", "1236549870", "676 Roger Blvd")));
	}
	
	@Test
	void testAddContactBadIDFail() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(new Contact("99999999999", "Phil", "Roberts", "1236549870", "676 Roger Blvd"));
		});
	}
	
	@Test
	void testAddContactNullIDFail() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.addContact(new Contact(null, "Phil", "Roberts", "1236549870", "676 Roger Blvd"));
		});
	}
	
	@Test
	void testDeleteContact() {
		assertTrue(service.removeContact("12345"));
		assertNull(service.getContact("12345"));
	}
	
	@Test
	void testDeleteContactNoContactFail() {
		assertFalse(service.removeContact("9999999999"));
	}
	
	@Test
	void testUpdateFirstName() {
		assertTrue(service.updateFirstName("12345", "Herman"));
		assertEquals("Herman", service.getContact("12345").getFirstName());
	}
	
	@Test
	void testUpdateFirstNameNullNameFail() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateFirstName("12345", null);
		});
	}
	
	@Test
	void testUpdateFirstNameLengthFail() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateFirstName("12345", "Leeeeeeerooooooooy");
		});
	}
	
	@Test
	void testUpdateFirstNameNullIdFail() {
		assertFalse(service.updateFirstName(null, "Herman"));
	}
	
	@Test
	void testUpdateFirstNameNoContactFail() {
		assertFalse(service.updateFirstName("9999999999", "Herman"));
	}
	
	@Test
	void testUpdateLastName() {
		assertTrue(service.updateLastName("12345", "Munster"));
		assertEquals("Munster", service.getContact("12345").getLastName());
	}
	
	@Test
	void testUpdateLastNameNullNameFail() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateLastName("12345", null);
		});
	}
	
	@Test
	void testUpdateLastNameLengthFail() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateLastName("12345", "Jeeeeeeeenkiiiiiins");
		});
	}
	
	@Test
	void testUpdateLastNameNullIdFail() {
		assertFalse(service.updateLastName(null, "Munster"));
	}
	
	@Test
	void testUpdateLastNameNoContactFail() {
		assertFalse(service.updateLastName("9999999999", "Munster"));
	}
	
	@Test
	void testUpdatePhone() {
		assertTrue(service.updatePhone("12345", "3855556685"));
		assertEquals("3855556685", service.getContact("12345").getPhone());
	}
	
	@Test
	void testUpdatePhoneNullFail() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updatePhone("12345", null);
		});
	}
	
	@Test
	void testUpdatePhoneIdNullFail() {
		assertFalse(service.updatePhone(null, "3855556685"));
	}
	
	@Test
	void testUpdatePhoneNoContactFail() {
		assertFalse(service.updatePhone("9999999999", "3855556685"));
	}
	
	@Test
	void testUpdatePhoneLongNumberFail() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updatePhone("12345", "38555566859");
		});
	}
	
	@Test
	void testUpdatePhoneShortNumberFail() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updatePhone("12345", "385555668");
		});
	}
	
	@Test
	void testUpdateAddress() {
		assertTrue(service.updateAddress("12345", "1313 Mockingbird Lane"));
		assertEquals("1313 Mockingbird Lane", service.getContact("12345").getAddress());
	}
	
	@Test
	void testUpdateAddressNullIdFail() {
		assertFalse(service.updateAddress(null, "1313 Mockingbird Lane"));
	}
	
	@Test
	void testUpdateAddressNoContactFail() {
		assertFalse(service.updateAddress("9999999999", "1313 Mockingbird Lane"));
	}
	
	@Test
	void testUpdateAddressNullAddressFail() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateAddress("12345", null);
		});
	}
	
	@Test
	void testUpdateAddressLengthFail() {
		assertThrows(IllegalArgumentException.class, () -> {
			service.updateAddress("12345", "123456789012345678901234567890123456789012345678901234567890");
		});
	}
}
