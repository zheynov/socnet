package by.zheynov.socnet.dao.impl;

import org.springframework.transaction.annotation.Transactional;

import by.zheynov.socnet.dao.UserRoleDao;
import by.zheynov.socnet.entity.RoleEntity;

/**
 * User's RoleEntity Implementation.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao.impl
 */

@Transactional
public class UserRoleDaoImpl extends AbstractBaseDAO implements UserRoleDao
{
	/**
	 * Saves userRole to database.
	 *
	 * @param userRole the entity
	 *
	 * @return the entity
	 */
	public RoleEntity createUserRole(final RoleEntity userRole)
	{
		super.save(userRole);
		return userRole;
	}

	/**
	 * Updates userRole in database.
	 *
	 * @param userRole the entity
	 */
	public void updateUserRole(final RoleEntity userRole)
	{
		super.udate(userRole);
	}

	/**
	 * Deletes userRole from database.
	 *
	 * @param userRole the entity
	 */
	public void deleteUserRole(final RoleEntity userRole)
	{
		super.delete(userRole);
	}

	/**
	 * Gets RoleEntity from database.
	 *
	 * @param userRoleId the id
	 *
	 * @return userRole entity
	 */
	public Object getById(final Long userRoleId)
	{
		return super.getById(RoleEntity.class, userRoleId);
	}
}
