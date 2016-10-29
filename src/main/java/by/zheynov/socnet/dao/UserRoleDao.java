package by.zheynov.socnet.dao;

import by.zheynov.socnet.entity.RoleEntity;


public interface UserRoleDao
{
	RoleEntity createUserRole(RoleEntity userRole);

	void updateUserRole(RoleEntity userRole);

	void deleteUserRole(RoleEntity userRole);
}
