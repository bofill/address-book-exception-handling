
@SuppressWarnings("serial")

class InvalidPhoneException extends Exception {

	InvalidPhoneException (String message){
		super("Invalid Phone Number \"" + message + "\". Must be exactly 10 digits");
	}
}
