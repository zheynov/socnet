package by.zheynov.socnet.dao;

import by.zheynov.socnet.entity.RoleEntity;

/**
 * RoleEntity interface.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao
 */

public interface UserRoleDao
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
