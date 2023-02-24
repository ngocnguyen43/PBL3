package utils.exceptions.authExceptions;

import utils.enums.ErrorCodes;
import utils.enums.ErrorStatusCodes;
import utils.exceptions.Exception;

public class RegistrationFailedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RegistrationFailedException() {
		this.message = "User failed to be registered";
		this.errorCode = ErrorCodes.RegistrationFailedException.getValue();
		this.statusCode = ErrorStatusCodes.RegistrationFailedException.getValue();
	}

}
