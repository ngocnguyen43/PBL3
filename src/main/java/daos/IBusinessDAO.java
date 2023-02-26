package daos;

import models.Business;

import java.util.List;

public interface IBusinessDAO extends GenericDAO<Business>{

	List<Business> findAll();
	String save(Business business);
	
	Business findOne(String name);
	
	Business findOneById(String id);
}
