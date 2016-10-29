package by.zheynov.socnet.service.impl;

import java.util.Locale;

import org.apache.log4j.Logger;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.transaction.annotation.Transactional;

import by.zheynov.socnet.dao.UserRoleDao;
import by.zheynov.socnet.dao.impl.UserRoleDaoImpl;
import by.zheynov.socnet.entity.RoleEntity;
import by.zheynov.socnet.service.UserRoleService;

public class UserRoleServiceImpl implements UserRoleService
{
	private final static Logger LOGGER = Logger.getLogger(UserRoleServiceImpl.class);
	private UserRoleDao                           userRoleDao;
	private ReloadableResourceBundleMessageSource messageSource;

	@Transactional
	public RoleEntity createUserRole(final RoleEntity userRole)
	{
		userRoleDao.createUserRole(userRole);
		LOGGER.info(messageSource.getMessage("service.user.role.save", new Object[] {userRole}, Locale.ENGLISH));
		return userRole;
	}

	@Transactional
	public void updateUserRole(final RoleEntity userRole)
	{
		userRoleDao.updateUserRole(userRole);
		LOGGER.info(messageSource.getMessage("service.user.role.update", new Object[] {userRole}, Locale.ENGLISH));
	}

	@Transactional
	public void deleteUserRole(final RoleEntity userRole)
	{
		userRoleDao.deleteUserRole(userRole);
		LOGGER.info(messageSource.getMessage("service.user.role.delete", new Object[] {userRole}, Locale.ENGLISH));
	}

	public void setUserRoleDao(final UserRoleDaoImpl userRoleDao)
	{
		this.userRoleDao = userRoleDao;
	}

	public void setMessageSource(ReloadableResourceBundleMessageSource messageSource)
	{
		this.messageSource = messageSource;
	}
}
