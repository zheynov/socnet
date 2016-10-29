package by.zheynov.socnet.service;

import by.zheynov.socnet.entity.RoleEntity;

public interface UserRoleService
{
	RoleEntity createUserRole(RoleEntity userRole);

	void updateUserRole(RoleEntity userRole);

	void deleteUserRole(RoleEntity userRole);
}
