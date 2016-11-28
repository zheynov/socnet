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
		profileEntity.setUserEntity(userEntity);
		profileEntity.setEmail(userEntity.getEmail());

		userEntity.setProfileEntity(profileEntity);
		userEntity.setEnabled(true);
		userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));

		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setId(2L);
		roleEntity.setRole("ROLE_USER");
		userEntity.setRoleEntity(roleEntity);

		profileDao.createProfile(profileEntity);
		userDao.createUser(userEntity);
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
	 * Returns a list of users with such email or username.
	 *
	 * @param username the username
	 * @param email    the email
	 *
	 * @return list of users
	 */
	@Transactional
	public List<UserEntity> getUserByUsernameOrEmail(final String username, final String email)
	{
		return userDao.getUserByUsernameOrEmail(username, email);
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
}