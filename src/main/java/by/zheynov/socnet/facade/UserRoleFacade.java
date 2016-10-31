package by.zheynov.socnet.facade;

import by.zheynov.socnet.entity.RoleEntity;

/**
 * User Role Facade interface.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.facade
 */

public interface UserRoleFacade
{
	/**
	 * Saves.
	 *
	 * @param userRole the entity
	 */
	RoleEntity createUserRole(RoleEntity userRole);

	/**
	 * Updates.
	 *
	 * @param userRole the entity
	 */
	void updateUserRole(RoleEntity userRole);

	/**
	 * Deletes.
	 *
	 * @param userRole the entity
	 */
	void deleteUserRole(RoleEntity userRole);
}
