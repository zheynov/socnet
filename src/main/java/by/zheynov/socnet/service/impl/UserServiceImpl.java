package by.zheynov.socnet.service.impl;

import by.zheynov.socnet.dao.ProfileDao;
import by.zheynov.socnet.dao.UserDao;
import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.entity.RoleEntity;
import by.zheynov.socnet.entity.UserEntity;
import by.zheynov.socnet.service.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

/**
 * UserService implementation.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.service.impl
 */
@Service("userService")
public class UserServiceImpl implements UserService
{
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private UserDao         userDao;
	@Autowired
	private ProfileDao      profileDao;
	@Autowired
	private MessageSource   messageSource;
	@Autowired
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
	@Transactional(readOnly = true)
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
	@Transactional(readOnly = true)
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
	@Transactional(readOnly = true)
	public List<UserEntity> getUserByUsernameOrEmail(final String username, final String email)
	{
		return userDao.getUserByUsernameOrEmail(username, email);
	}
}