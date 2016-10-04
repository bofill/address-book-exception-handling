import java.util.Arrays;


public class Contact {
	private final char[] VALID_PHONE_NUMBER = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

	private String name;
	private String email;
	private String phone;


	public Contact(String name, String email, String phone) throws InvalidEmailTypeException, InvalidPhoneException{
		this.name = name;
		this.email = email;
		validateEmail(email);
		this.phone = phone;
		validatePhone(phone);
	}


	public String printContact() {
		return name + "\t\t" + email + "\t\t" + phone;
	}	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;

	}

	public void setEmail(String email) throws InvalidEmailTypeException{
		this.email = email;
		validateEmail(email);
	}

	public String getPhone(String phone) {
		return phone;
	}

	public void setPhone(String phone) throws InvalidPhoneException{
		this.phone = phone;
		validatePhone(phone);
	}

	private String validatePhone(String phone) throws InvalidPhoneException{
		boolean phoneLength10 = (phone.toCharArray().length == 10);
		for (char c: phone.toCharArray())
			if ((Arrays.binarySearch(VALID_PHONE_NUMBER, c) >= 0) && phoneLength10){
			} else {
				throw new InvalidPhoneException(phone);
			}
		return phone;
	}

	
	private String validateEmail(String email) throws InvalidEmailTypeException{
		boolean atSignPresent = (email.indexOf("@") >= 0);
		boolean periodPresent = (email.indexOf(".") >= 0);
		boolean indexesAreEqual = (email.indexOf("@") == email.lastIndexOf("@"));
				
		if (!(atSignPresent && periodPresent && indexesAreEqual)) {
			throw new InvalidEmailTypeException(email);
		}
		return email;
	}
}
