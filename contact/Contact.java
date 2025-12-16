package com.contact;

public class Contact {
private String contactId;
private String firstName;
private String lastName;
private String phone;
private String address;

public Contact(String contactId, String firstName, String lastName, String phone, String address) {
	if(contactId == null || contactId.length() > 10) {
		throw new IllegalArgumentException("Invalid contact ID");
	}
	
	if (firstName == null || firstName.length() > 10) {
		throw new IllegalArgumentException("Invalid entry for First Name");
	}
	
	if (lastName == null || lastName.length() > 10) {
		throw new IllegalArgumentException("Invalid entry for Last Name");
	}
	
	if (phone == null || phone.length() != 10) {
		throw new IllegalArgumentException("Invalid entry for Phone Number");
	}
	
	if (address == null || address.length() > 30) {
		throw new IllegalArgumentException("Invalid entry for Address");
	}
	
	this.contactId = contactId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.phone = phone;
	this.address = address;
}

public String getContactId() {
	return this.contactId;
}

public String getFirstName() {
	return this.firstName;
}

public void setFirstName(String newFirstName) {
	if (newFirstName != null && newFirstName.length() <= 10) {
		this.firstName = newFirstName;
	}
	else {
		throw new IllegalArgumentException("Invalid entry for First Name");
	}
}

public String getLastName() {
	return this.lastName;
}

public void setLastName(String newLastName) {
	if (newLastName != null && newLastName.length() <= 10) {
		this.lastName = newLastName;
	}
	else {
		throw new IllegalArgumentException("Invalid entry for Last Name");
	}
}

public String getPhone() {
	return this.phone;
}

public void setPhone(String newPhone) {
	if (newPhone != null && newPhone.length() == 10) {
		this.phone = newPhone;
	}
	else {
		throw new IllegalArgumentException("Invalid entry for Phone Number");
	}
}

public String getAddress() {
	return this.address;
}

public void setAddress(String newAddress) {
	if (newAddress != null && newAddress.length() <= 30) {
		this.address = newAddress;
	}
	else {
		throw new IllegalArgumentException("Invalid entry for Address");
	}
}

}
