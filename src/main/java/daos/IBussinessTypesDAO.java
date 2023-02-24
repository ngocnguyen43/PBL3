package daos;

import models.BusinessTypes;

public interface IBussinessTypesDAO extends GenericDAO<BusinessTypes>{
	String save(BusinessTypes businessTypes);
	BusinessTypes findOne(String name);
}
