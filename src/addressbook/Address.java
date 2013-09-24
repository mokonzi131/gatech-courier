package addressbook;

public class Address {
	private String _name;
	private String _address;
	private PhoneNumber _phone;
	private String _note;
	
	public Address() {
		_name = "Joe Smith";
		_address = "123 4th Street, Atlanta, GA 30363";
		_phone = new PhoneNumber();
		_note = "This is a really cool cat!";
	}
	
	public Address(String name, String address, PhoneNumber number, String note) {
		_name = name;
		_address = address;
		_phone = number;
		_note = note;
	}
	
	public String name() { return _name; }
	public String address() { return _address; }
	public PhoneNumber number() { return _phone; }
	public String note() { return _note; }
	
	public String pretty() {
		String result = "";
		
		result += "Name: " + _name + "\n";
		result += "Address: " + _address + "\n";
		result += "Telephone: " + _phone.toString() + "\n";
		result += "NOTES: \n" + _note;
		
		return result;
	}
}
