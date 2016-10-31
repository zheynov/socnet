package by.zheynov.socnet.service;

import by.zheynov.socnet.entity.RoleEntity;

/**
 * User's Role Service interface.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.service
 */

public interface UserRoleService
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
