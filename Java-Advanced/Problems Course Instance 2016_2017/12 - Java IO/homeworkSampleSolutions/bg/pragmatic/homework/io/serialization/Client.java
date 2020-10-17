package bg.pragmatic.homework.io.serialization;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Client implements Serializable {	
	private int accountNumber;
	private String fullName;
	private String ID;
	private String phone;
	private String email;
	private String address;
	
	public Client(int accountNumber, String fullName, String ID, String phone,
			String email, String address) {
		super();
		this.accountNumber = accountNumber;
		this.fullName = fullName;
		this.ID = ID;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public String getFullName() {
		return fullName;
	}

	public String getID() {
		return ID;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}
}
