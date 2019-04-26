
public class Client {

	private String name;
	private String surname;
	private String nationalID;
	private String address;
	private String phoneNumber;

	public Client(String name, String surname, String nationalID, String address, String phoneNumber) {
		super();
		this.name = name;
		this.surname = surname;
		this.nationalID = nationalID;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public Client() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getNationalID() {
		return nationalID;
	}

	public void setNationalID(String nationalID) {
		this.nationalID = nationalID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public static Client createClientA() {
		Client client = new Client();
		client.setName("Nombre A");
		client.setSurname("Apellidos A");
		client.setNationalID("43111222E");
		client.setAddress("C/Callecita N5, 2A");
		client.setPhoneNumber("900000000");
		return client;
	}

	public static Client createClientB() {
		Client client = new Client();
		client.setName("Nombre B");
		client.setSurname("Apellidos B");
		client.setNationalID("43333444E");
		client.setAddress("C/Callecita 2 N5, 2A");
		client.setPhoneNumber("901000000");
		return client;
	}

}
