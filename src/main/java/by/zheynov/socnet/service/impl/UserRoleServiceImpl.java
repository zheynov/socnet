package by.zheynov.socnet.service.impl;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
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
public class UserRoleServiceImpl implements UserRoleService
{
	private final static Logger LOGGER = Logger.getLogger(UserRoleServiceImpl.class);
	private UserRoleDao                           userRoleDao;
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
		LOGGER.info(messageSource.getMessage("service.user.role.save", new Object[] {userRole}, Locale.ENGLISH));
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
		LOGGER.info(messageSource.getMessage("service.user.role.update", new Object[] {userRole}, Locale.ENGLISH));
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
		LOGGER.info(messageSource.getMessage("service.user.role.delete", new Object[] {userRole}, Locale.ENGLISH));
	}

	/**
	 * Sets new messageSource.
	 *
	 * @param messageSource New value of messageSource.
	 */
	public void setMessageSource(final ReloadableResourceBundleMessageSource messageSource)
	{
		this.messageSource = messageSource;
	}

	/**
	 * Sets new userRoleDao.
	 *
	 * @param userRoleDao New value of userRoleDao.
	 */
	public void setUserRoleDao(final UserRoleDao userRoleDao)
	{
		this.userRoleDao = userRoleDao;
	}
}
