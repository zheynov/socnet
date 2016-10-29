package by.zheynov.socnet.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;

import by.zheynov.socnet.entity.RoleEntity;
import by.zheynov.socnet.facade.UserRoleFacade;
import by.zheynov.socnet.service.UserRoleService;

public class UserRoleFacadeImpl implements UserRoleFacade
{
	@Autowired
	UserRoleService userRoleService;

	public RoleEntity createUserRole(final RoleEntity userRole)
	{
		return userRoleService.createUserRole(userRole);
	}

	public void updateUserRole(final RoleEntity userRole)
	{
		userRoleService.updateUserRole(userRole);
	}

	public void deleteUserRole(final RoleEntity userRole)
	{
		userRoleService.deleteUserRole(userRole);
	}
}
