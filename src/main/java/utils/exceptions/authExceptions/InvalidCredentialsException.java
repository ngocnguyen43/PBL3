package utils.exceptions.authExceptions;

import utils.enums.ErrorCodes;
import utils.enums.ErrorStatusCodes;
import utils.exceptions.Exception;

public class InvalidCredentialsException extends Exception {

	public InvalidCredentialsException(String message) {
		this.message = message;
		this.errorCode = ErrorCodes.InvalidCredentialsException.getValue();
		this.statusCode = ErrorStatusCodes.InvalidCredentialsException.getValue();
	}
}
