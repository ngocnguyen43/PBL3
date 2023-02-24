package utils.exceptions.dbExceptipns;

import utils.enums.ErrorCodes;
import utils.enums.ErrorStatusCodes;
import utils.exceptions.Exception;

public class NotFoundException extends Exception {


	
	public NotFoundException(String message) {
		this.message = message;
		this.errorCode = ErrorCodes.NotFoundException.getValue();
		this.statusCode = ErrorStatusCodes.NotFoundException.getValue();
	}
}
