package by.zheynov.socnet.facade;

import by.zheynov.socnet.entity.RoleEntity;

public interface UserRoleFacade
{
	RoleEntity createUserRole(RoleEntity userRole);

	void updateUserRole(RoleEntity userRole);

	void deleteUserRole(RoleEntity userRole);
}
