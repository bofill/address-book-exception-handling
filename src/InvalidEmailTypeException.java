
@SuppressWarnings("serial")

	class InvalidEmailTypeException extends Exception{

	InvalidEmailTypeException(String message) {
		super("Invalid Email " + message + " .Must contain only one @ sign and at least one (.)");
	}
}
