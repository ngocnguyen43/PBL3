package repositories;

import models.User;
import utils.exceptions.authExceptions.InvalidCredentialsException;
import utils.exceptions.authExceptions.RegistrationFailedException;
import utils.exceptions.dbExceptipns.DuplicateEntryException;
import utils.messages.Message;

public interface IAuthRepository {
	Message registerUser(User user) throws DuplicateEntryException, InvalidCredentialsException, Exception, RegistrationFailedException;

	Message loginUser(User user) throws InvalidCredentialsException, Exception;
}
