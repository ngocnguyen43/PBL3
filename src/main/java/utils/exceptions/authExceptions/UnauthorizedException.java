package utils.exceptions.authExceptions;

import utils.enums.ErrorCodes;
import utils.enums.ErrorStatusCodes;
import utils.exceptions.Exception;

public class UnauthorizedException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnauthorizedException() {
		this.message = "User unauthorized for action";
		this.errorCode = ErrorCodes.UnauthorizedException.getValue();
		this.statusCode = ErrorStatusCodes.UnauthorizedException.getValue();
	}
}
