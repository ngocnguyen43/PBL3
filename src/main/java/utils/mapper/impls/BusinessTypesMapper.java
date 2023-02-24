package utils.mapper.impls;

import models.BusinessTypes;
import utils.mapper.IMapper;

import java.sql.ResultSet;

public class BusinessTypesMapper implements IMapper<BusinessTypes> {

	@Override
	public BusinessTypes mapRow(ResultSet result) {
		// TODO Auto-generated method stub
		BusinessTypes businessTypes = new BusinessTypes();
		try {
			businessTypes.setId(result.getString("type_id"));
			businessTypes.setBusinessId(result.getString("business_id"));
			businessTypes.setTypeName(result.getString("type_name"));
			businessTypes.setModifiedBy(result.getString("modified_by"));
			businessTypes.setUpdatedAt(result.getTimestamp("updated_at"));
			businessTypes.setCreatedAt(result.getTimestamp("created_at"));
			return businessTypes;
//			bussinessTypes.set
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

}
