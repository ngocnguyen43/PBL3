package daos.impls;


import daos.IBussinessTypesDAO;
import models.BusinessTypes;
import utils.mapper.impls.BusinessTypesMapper;

import java.util.List;

public class BussinessTypesDAO extends AbstractDAO<BusinessTypes> implements IBussinessTypesDAO {

	@Override
	public String save(BusinessTypes businessTypes) {
		String sql = "INSERT INTO business_types (type_id,business_id,"
				+ "type_name,"
				+ "modified_by,) VALUES (?,?,?,?)";
		insert(sql, businessTypes.getId(),businessTypes.getBusinessId(),businessTypes.getTypeName(),businessTypes.getModifiedBy());
		return businessTypes.getId();
	}

	@Override
	public BusinessTypes  findOne(String name) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM business_types WHERE type_name = ?";
		List<BusinessTypes> businessTypes = query(sql, new BusinessTypesMapper(), name);
		return businessTypes.isEmpty() ? null : businessTypes.get(0);
	}

}
