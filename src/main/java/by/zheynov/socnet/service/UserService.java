package by.zheynov.socnet.service;

import by.zheynov.socnet.entity.UserEntity;

import java.util.List;

/**
 * User Service interface.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.service
 */

public interface UserService
{

	/**
	 * Saves.
	 *
	 * @param userEntity the entity
	 */
	void createUser(UserEntity userEntity);

	/**
	 * Updates.
	 *
	 * @param userEntity the entity
	 */
	void updateUser(UserEntity userEntity);

	/**
	 * Deletes.
	 *
	 * @param userEntity the entity
	 */
	void deleteUser(UserEntity userEntity);

	/**
	 * Finds UserEntity By login.
	 *
	 * @param username the username
	 *
	 * @return the UserEntity
	 */
	UserEntity getUserByUsername(String username);

	/**
	 * Retrieves a list of UserEntity objects.
	 *
	 * @return the List<UserEntity>
	 */
	List<UserEntity> getAllTheUsers();

	/**
	 * Returns a list of users with such email or username
	 *
	 * @param username the username
	 * @param email    the email
	 *
	 * @return list of users
	 */
	public List<UserEntity> getUserByUsernameOrEmail(String username,  String email);

}
