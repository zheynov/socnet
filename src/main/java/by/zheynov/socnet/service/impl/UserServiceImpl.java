package by.zheynov.socnet.service.impl;

import by.zheynov.socnet.dao.ProfileDao;
import by.zheynov.socnet.dao.UserDao;
import by.zheynov.socnet.dao.UserRoleDao;
import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.entity.RoleEntity;
import by.zheynov.socnet.entity.UserEntity;
import by.zheynov.socnet.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

/**
 * UserService implementation.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.service.impl
 */
public class UserServiceImpl implements UserService
{
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	private UserDao         userDao;
	private ProfileDao      profileDao;
	private UserRoleDao     userRoleDao;
	private MessageSource   messageSource;
	private PasswordEncoder passwordEncoder;

	/**
	 * Saves user and profile to database.
	 *
	 * @param userEntity the entity
	 */
	@Transactional
	public void createUser(final UserEntity userEntity)
	{
		ProfileEntity profileEntity = new ProfileEntity();
		profileEntity.setUser(userEntity);
		profileEntity.setEmail(userEntity.getEmail());

		userEntity.setProfileEntity(profileEntity);
		userEntity.setEnabled(true);
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));

		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setUsername(userEntity.getUsername());
		roleEntity.setRole("ROLE_USER");

		profileDao.createProfile(profileEntity);
		userDao.createUser(userEntity);
		userRoleDao.createUserRole(roleEntity);
		LOGGER.info(messageSource.getMessage("service.user.save", new Object[] {userEntity}, Locale.ENGLISH));
	}

	/**
	 * Updates the user in database.
	 *
	 * @param userEntity the entity
	 */
	@Transactional
	public void updateUser(final UserEntity userEntity)
	{
		userDao.updateUser(userEntity);
		LOGGER.info(messageSource.getMessage("service.user.update", new Object[] {userEntity}, Locale.ENGLISH));

	}

	/**
	 * Gets user from database by its username.
	 *
	 * @param username the username
	 *
	 * @return the entity
	 */
	@Transactional
	public UserEntity getUserByUsername(final String username)
	{
		LOGGER.info(messageSource.getMessage("service.user.getByLogin", new Object[] {username}, Locale.ENGLISH));
		return userDao.getUserByUsername(username);
	}

	/**
	 * Deletes user from database.
	 *
	 * @param userEntity the entity
	 */
	@Transactional
	public void deleteUser(final UserEntity userEntity)
	{
		userDao.deleteUser(userEntity);
		LOGGER.info(messageSource.getMessage("service.user.delete", new Object[] {userEntity}, Locale.ENGLISH));
	}

	/**
	 * Gets a list of users.
	 *
	 * @return List<UserEntity>
	 */
	@Transactional
	public List<UserEntity> getAllTheUsers()
	{
		return userDao.getAllTheUsers();
	}

	/**
	 * Ckecks if user with such username already exists in database.
	 *
	 * @param username the username
	 *
	 * @return true if username is exits, otherwise false
	 */
	public boolean isUsernameExists(final String username)
	{
		return userDao.isUsernameExists(username);
	}

	/**
	 * Ckecks if user with such email already exists in database.
	 *
	 * @param email the email
	 *
	 * @return true if email is exits, otherwise false
	 */
	public boolean isEmailExists(final String email)
	{
		return userDao.isEmailExists(email);
	}

	/**
	 * Sets new userDao.
	 *
	 * @param userDao New value of userDao.
	 */
	public void setUserDao(final UserDao userDao)
	{
		this.userDao = userDao;
	}

	/**
	 * Sets new profileDao.
	 *
	 * @param profileDao New value of profileDao.
	 */
	public void setProfileDao(final ProfileDao profileDao)
	{
		this.profileDao = profileDao;
	}

	/**
	 * Sets new passwordEncoder.
	 *
	 * @param passwordEncoder New value of passwordEncoder.
	 */
	public void setPasswordEncoder(final PasswordEncoder passwordEncoder)
	{
		this.passwordEncoder = passwordEncoder;
	}

	/**
	 * Sets new messageSource.
	 *
	 * @param messageSource New value of messageSource.
	 */
	public void setMessageSource(final MessageSource messageSource)
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