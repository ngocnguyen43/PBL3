package daos;

import models.Role;

import java.util.List;

public interface IRoleDAO extends GenericDAO<Role> {
	List<Role> findAll();

	Role findByRoleId(Integer roleId);
}
