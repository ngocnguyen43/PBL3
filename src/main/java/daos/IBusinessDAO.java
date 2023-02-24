package daos;

import models.Business;

public interface IBusinessDAO extends GenericDAO<Business>{
	String save(Business business);
	
	Business findOne(String name);
	
	Business findOneById(String id);
}
