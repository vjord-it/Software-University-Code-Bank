package task05_serialization;

import java.io.Serializable;

public class Person implements Serializable {
	
	private static final long serialVersionUID = -8357317117344532718L;

	private String fullName;
	private long id;
	private String accountNumber;
	private String phone;
	private String email;
	private String address;

	public Person(String fullName, long id, String accountNumber, String phone, String email, String address) {
		super();
		this.setFullName(fullName);
		this.setId(id);
		this.setAccountNumber(accountNumber);
		this.setPhone(phone);
		this.setEmail(email);
		this.setAddress(address);
	}

	private void setAccountNumber(String accountNumber) {
		validateTextFieldData(accountNumber);
		this.accountNumber = accountNumber;
	}

	private void setFullName(String fullName) {
		validateTextFieldData(fullName);
		this.fullName = fullName;
	}

	private void setId(long id) {
		this.id = id;
	}

	private void setPhone(String phone) {
		validateTextFieldData(phone);
		this.phone = phone;
	}

	private void setEmail(String email) {
		validateTextFieldData(email);
		this.email = email;
	}

	private void setAddress(String address) {
		validateTextFieldData(address);
		this.address = address;
	}

	private void validateTextFieldData(String string) {
		if (string == null || string.isEmpty()) {
			throw new IllegalArgumentException("Invalid data for text field");
		}
	}

	public String getPersonDetails( ) {
		return String.format("Name: %s%n\tAccount: %s%n\tID: %d%n\tPhone: %s%n\tE-mail: %s%n\tAddress: %s",
				fullName, accountNumber, id, phone, email, address);
	}
}
