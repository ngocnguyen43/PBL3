package services.impls;

import dtos.UserDTO;
import dtos.UserSigninDTO;
import models.User;
import repositories.IAuthRepository;
import services.IAuthService;
import utils.exceptions.authExceptions.InvalidCredentialsException;
import utils.exceptions.authExceptions.RegistrationFailedException;
import utils.exceptions.dbExceptipns.DuplicateEntryException;
import utils.helper.Helper;
import utils.messages.Message;
import utils.messages.Meta;

import javax.inject.Inject;

public class AuthService implements IAuthService {

	@Inject
	private IAuthRepository authRepository;

	@Override
	public Message Signin(UserSigninDTO tempUser) {
		try {
			User user = Helper.objectMapper(tempUser, User.class);
			Message message = authRepository.loginUser(user);
			return message;
		} catch (InvalidCredentialsException e) {
			Meta meta = new Meta.Builder(e.getStatusCode()).withError(e.getMessage()).build();
			Message message = new Message.Builder(meta).build();
			return message;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Meta meta = new Meta.Builder(500).withError("HAHAA").build();
			Message message = new Message.Builder(meta).build();
			return message;
		}
//		
	}

	@Override
	public Message Register(UserDTO userDTO) {

		try {
			User user = Helper.objectMapper(userDTO, User.class);
			Message message = authRepository.registerUser(user);
			return message;
		} catch (DuplicateEntryException | InvalidCredentialsException | RegistrationFailedException e) {
			Meta meta = new Meta.Builder(e.getStatusCode()).withErrCode(e.getErrorCode()).withError(e.getMessage())
					.build();
			Message message = new Message.Builder(meta).build();
			return message;
		} catch (Exception e) {
			e.printStackTrace();
			Meta meta = new Meta.Builder(500).withError("HAHAA").build();
			Message message = new Message.Builder(meta).build();
			return message;

		}

	}

}
