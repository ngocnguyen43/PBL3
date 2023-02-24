package daos;

import models.User;

import java.util.List;

public interface IUserDAO extends GenericDAO<User> {
	List<User> findAll();

	User findByUserId(String id);
	
	User findByEmail(String email);
	
	User findByNationalId(String nationalId);
	
	String save(User user);
	
	void delete(String USerId);

}
