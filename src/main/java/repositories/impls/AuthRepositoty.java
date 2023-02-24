package repositories.impls;

import daos.IUserDAO;
import models.User;
import repositories.IAuthRepository;
import utils.exceptions.authExceptions.InvalidCredentialsException;
import utils.exceptions.authExceptions.RegistrationFailedException;
import utils.exceptions.dbExceptipns.DuplicateEntryException;
import utils.helper.DecryptPassword;
import utils.helper.JWTGeneration;
import utils.helper.RandomTokenGenearation;
import utils.messages.Data;
import utils.messages.Message;
import utils.messages.Meta;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.HashMap;

public class AuthRepositoty implements IAuthRepository {

	@Inject
	private IUserDAO userDao;

	@Override
	public Message registerUser(User domainUser) throws DuplicateEntryException, InvalidCredentialsException, Exception, RegistrationFailedException {
		boolean isEmailExist = userDao.findByEmail(domainUser.getEmail()) != null;
		if (isEmailExist)
			throw new DuplicateEntryException("Email is already used!");
		boolean isNationalIdExist = userDao.findByNationalId(domainUser.getNationalId()) != null;
		if (isNationalIdExist)
			throw new DuplicateEntryException("NationalId is already used");
	
		String id = userDao.save(domainUser);
		if (id == null) throw new RegistrationFailedException();
		Message message = loginUser(domainUser);
		return message;
	}

	@Override
	public Message loginUser(User domainUser) throws InvalidCredentialsException, Exception {
		HashMap<String, String> claims = new HashMap<>();
		JWTGeneration JWT = new JWTGeneration();
		boolean isExist = userDao.findByEmail(domainUser.getEmail()) == null;
		if (isExist)
			throw new NotFoundException("User not found!");
		User user = userDao.findByEmail(domainUser.getEmail());
		String hashedPassword = user.getPassword();
		String password = domainUser.getPassword();
		if (!DecryptPassword.Decrypt(password, hashedPassword))
			throw new InvalidCredentialsException("Wrong password");

		String userId = user.getId();
		claims.put("userId", userId);
		claims.put("role", user.getRole().getRoleCode());
		String accessToken = JWT.generate(claims);
		String refreshToken = RandomTokenGenearation.getRandomHexString(40);

		Data data = new Data.Builder(accessToken).withRefreshToken(refreshToken).build();
		Meta meta = new Meta.Builder(200).withMessage("Login Success!").build();
		Message message = new Message.Builder(meta).withData(data).build();

		return message;
	}

}
