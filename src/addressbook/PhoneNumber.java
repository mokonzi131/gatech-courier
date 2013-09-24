package addressbook;

public class PhoneNumber {
	private String _areaCode;
	private String _leading;
	private String _trailing;
	
	public PhoneNumber() {
		_areaCode = "123";
		_leading = "456";
		_trailing = "7890";
	}
	
	public PhoneNumber(String areaCode, String leading, String trailing) {
		_areaCode = format(areaCode);
		_leading = format(leading);
		_trailing = format(trailing);
	}
	
	private String format(String entry) {
//		int count = entry.length();
//		String result = "";
//		for (int index = 0; index < count; ++index) {
//			char test = entry.charAt(index);
//			if (String.valueOf(test).matches("([0-9])"))
//				result.concat(String.valueOf(test));
//			else
//				result.concat("X");
//		}
//		return result;
		return entry;
	}
	
	public String toString() {
		return "(" +_areaCode+ ") " +_leading+ "-" + _trailing;
	}
}
