package mcdata;

import java.util.List;

import addressbook.Address;
import addressbook.AddressBook;

public class MCDataMaster {
	private static MCDataMaster _instance = null;
	public static synchronized MCDataMaster getInstance() {
		if (_instance == null)
			_instance = new MCDataMaster();
		return _instance;
	}
	
	private AddressBook _addressBook;
	
	private MCDataMaster() {
		_addressBook = new AddressBook();
	}
	
	public List<Address> addresses() { return _addressBook.getList(); }
}
