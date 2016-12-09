package by.zheynov.socnet.service.impl;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.zheynov.socnet.dao.UserRoleDao;
import by.zheynov.socnet.entity.RoleEntity;
import by.zheynov.socnet.service.UserRoleService;

/**
 * User's role service implementation.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.service
 */
@Service("userRoleService")
public class UserRoleServiceImpl implements UserRoleService
{
	@Autowired
	private UserRoleDao                           userRoleDao;
	@Autowired
	private ReloadableResourceBundleMessageSource messageSource;

	/**
	 * Saves userRole to database.
	 *
	 * @param userRole the entity
	 *
	 * @return the entity
	 */
	@Transactional
	public RoleEntity createUserRole(final RoleEntity userRole)
	{
		userRoleDao.createUserRole(userRole);
		return userRole;
	}

	/**
	 * Updates userRole in database.
	 *
	 * @param userRole the entity
	 */
	@Transactional
	public void updateUserRole(final RoleEntity userRole)
	{
		userRoleDao.updateUserRole(userRole);
	}

	/**
	 * Deletes userRole from database.
	 *
	 * @param userRole the entity
	 */
	@Transactional
	public void deleteUserRole(final RoleEntity userRole)
	{
		userRoleDao.deleteUserRole(userRole);
	}
}
