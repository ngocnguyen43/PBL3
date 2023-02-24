package utils.exceptions.dbExceptipns;

import utils.enums.ErrorCodes;
import utils.enums.ErrorStatusCodes;
import utils.exceptions.Exception;

public class DuplicateEntryException extends Exception {



	public DuplicateEntryException(String message) {
		this.message = message;
		this.errorCode = ErrorCodes.DuplicateEntryException.getValue();
		this.statusCode = ErrorStatusCodes.DuplicateEntryException.getValue();
	}
}
