package by.zheynov.socnet.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.zheynov.socnet.entity.RoleEntity;
import by.zheynov.socnet.facade.UserRoleFacade;
import by.zheynov.socnet.service.UserRoleService;

/**
 * User's role facade implementation.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.facade
 */
@Component("userRoleFacade")
public class UserRoleFacadeImpl implements UserRoleFacade
{
	@Autowired
	private UserRoleService userRoleService;

	/**
	 * Saves userRole to database.
	 *
	 * @param userRole the entity
	 *
	 * @return the entity
	 */
	public RoleEntity createUserRole(final RoleEntity userRole)
	{
		return userRoleService.createUserRole(userRole);
	}

	/**
	 * Updates userRole in database.
	 *
	 * @param userRole the entity
	 */
	public void updateUserRole(final RoleEntity userRole)
	{
		userRoleService.updateUserRole(userRole);
	}

	/**
	 * Deletes userRole from database.
	 *
	 * @param userRole the entity
	 */
	public void deleteUserRole(final RoleEntity userRole)
	{
		userRoleService.deleteUserRole(userRole);
	}
}
