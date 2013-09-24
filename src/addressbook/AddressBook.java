package addressbook;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {
	private List<Address> _addresses;
	
	public AddressBook() {
		_addresses = new ArrayList<>();
		
		_addresses.add(new Address());
		_addresses.add(new Address("Jeff Smith", "123 4th St EW, Atlanta, GA 30300", new PhoneNumber("193","234","0911"), "another cool cat"));
		_addresses.add(new Address("Ceff Smith", "123 4th St EW, Atlanta, GA 30301", new PhoneNumber("193","234","0912"), "another cool cats"));
		_addresses.add(new Address("Deff Smith", "123 4th St EW, Atlanta, GA 30302", new PhoneNumber("193","234","0913"), "another cool catz"));
		_addresses.add(new Address("Seff Smith", "123 4th St EW, Atlanta, GA 30303", new PhoneNumber("193","234","0914"), "another cool catw"));
		_addresses.add(new Address("Aeff Smith", "123 4th St EW, Atlanta, GA 30304", new PhoneNumber("193","234","0915"), "another cool catye"));
		_addresses.add(new Address("Qeff Smith", "123 4th St EW, Atlanta, GA 30305", new PhoneNumber("193","234","0916"), "another cool catv"));
		_addresses.add(new Address("Weff Smith", "123 4th St EW, Atlanta, GA 30306", new PhoneNumber("193","234","0917"), "another cool cata"));
		_addresses.add(new Address("Eeff Smith", "123 4th St EW, Atlanta, GA 30307", new PhoneNumber("193","234","0918"), "another cool cath"));
		_addresses.add(new Address("Reff Smith", "123 4th St EW, Atlanta, GA 30308", new PhoneNumber("193","234","0919"), "another cool catn"));
		_addresses.add(new Address("Zeff Smith", "123 4th St EW, Atlanta, GA 30309", new PhoneNumber("193","234","1091"), "another cool catu"));
		_addresses.add(new Address("Xeff Smith", "123 4th St EW, Atlanta, GA 30310", new PhoneNumber("193","234","2091"), "another cool cat,"));
		_addresses.add(new Address("Veff Smith", "123 4th St EW, Atlanta, GA 30311", new PhoneNumber("193","234","3091"), "another cool catk"));
		_addresses.add(new Address("Beff Smith", "123 4th St EW, Atlanta, GA 30312", new PhoneNumber("193","234","4091"), "another cool caty"));
		_addresses.add(new Address("Geff Smith", "123 4th St EW, Atlanta, GA 30313", new PhoneNumber("193","234","5091"), "another cool cat6"));
		_addresses.add(new Address("Teff Smith", "123 4th St EW, Atlanta, GA 30314", new PhoneNumber("193","234","6091"), "another cool cat7"));
		_addresses.add(new Address("Yeff Smith", "123 4th St EW, Atlanta, GA 30315", new PhoneNumber("193","234","7091"), "another cool cat8"));
		_addresses.add(new Address("Heff Smith", "123 4th St EW, Atlanta, GA 30316", new PhoneNumber("193","234","8091"), "another cool cats"));
		_addresses.add(new Address("Neff Smith", "123 4th St EW, Atlanta, GA 30318", new PhoneNumber("193","234","9091"), "another cool catu"));
	}
	
	public List<Address> getList() { return _addresses; }
}
