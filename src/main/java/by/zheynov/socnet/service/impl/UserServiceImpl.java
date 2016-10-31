package by.zheynov.socnet.service.impl;

import by.zheynov.socnet.dao.ProfileDao;
import by.zheynov.socnet.dao.UserDao;
import by.zheynov.socnet.dao.UserRoleDao;
import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.entity.RoleEntity;
import by.zheynov.socnet.entity.UserEntity;
import by.zheynov.socnet.service.PasswordEncoding;
import by.zheynov.socnet.service.ProfileService;
import by.zheynov.socnet.service.UserRoleService;
import by.zheynov.socnet.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

public class UserServiceImpl implements UserService
{

	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	private UserDao       userDao;
	private ProfileDao    profileDao;
	private UserRoleDao   userRoleDao;
	private MessageSource messageSource;

	@Transactional
	public void createUser(final UserEntity userEntity)
	{

		ProfileEntity profileEntity = new ProfileEntity();
		profileEntity.setUser(userEntity);
		profileEntity.setEmail(userEntity.getEmail());

		userEntity.setProfileEntity(profileEntity);
		userEntity.setPassword(PasswordEncoding.encodePassword(userEntity.getPassword()));
		userEntity.setEnabled(true);

		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setUsername(userEntity.getUsername());
		roleEntity.setRole("ROLE_USER");


		profileDao.createProfile(profileEntity);
		userDao.createUser(userEntity);
		userRoleDao.createUserRole(roleEntity);
		LOGGER.info(messageSource.getMessage("service.user.save", new Object[] {userEntity}, Locale.ENGLISH));
	}

	@Transactional
	public void updateUser(final UserEntity userEntity)
	{
		userDao.updateUser(userEntity);
		LOGGER.info(messageSource.getMessage("service.user.update", new Object[] {userEntity}, Locale.ENGLISH));

	}

	@Transactional
	public UserEntity getUserByLogin(String login)
	{
		LOGGER.info(messageSource.getMessage("service.user.getByLogin", new Object[] {login}, Locale.ENGLISH));
		return userDao.getUserByLogin(login);
	}

	@Transactional
	public void deleteUser(final UserEntity userEntity)
	{
		userDao.deleteUser(userEntity);
		LOGGER.info(messageSource.getMessage("service.user.delete", new Object[] {userEntity}, Locale.ENGLISH));
	}

	@Transactional
	public List<UserEntity> getAllTheUsers()
	{
		return userDao.getAllTheUsers();
	}

	public boolean isPasswpodlCorrect(UserDTO userDTO)
	{
		return userDao.isUserPasswpodlCorrect(userDTO);
	}

	public boolean isLoginExists(String login)
	{
		return userDao.isLoginExists(login);
	}

	public boolean isEmailExists(String email)
	{
		return userDao.isEmailExists(email);
	}

	public void setUserDao(UserDao userDao)
	{
		this.userDao = userDao;
	}

	public void setProfileDao(ProfileDao profileDao)
	{
		this.profileDao = profileDao;
	}

	public void setMessageSource(MessageSource messageSource)
	{
		this.messageSource = messageSource;
	}

	public void setUserRoleDao(UserRoleDao userRoleDao)
	{
		this.userRoleDao = userRoleDao;
	}


}
