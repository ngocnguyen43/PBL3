package services;

import dtos.UserDTO;
import dtos.UserSigninDTO;
import utils.messages.Message;

public interface IAuthService {
	Message Signin(UserSigninDTO user);
	Message Register(UserDTO user);
}
