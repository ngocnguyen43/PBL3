package utils.exceptions.dbExceptipns;

import utils.enums.ErrorCodes;
import utils.enums.ErrorStatusCodes;
import utils.exceptions.Exception;

public class CreateFailedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CreateFailedException(String message) {
		this.message = message;
		this.errorCode = ErrorCodes.CreateFailedException.getValue();
		this.statusCode = ErrorStatusCodes.CreateFailedException.getValue();
		
	}
}
