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
	 * @param login the login
	 *
	 * @return the UserEntity
	 */
	UserEntity getUserByLogin(String login);

	/**
	 * Retrieves a list of UserEntity objects.
	 *
	 * @return the List<UserEntity>
	 */
	List<UserEntity> getAllTheUsers();

	/**
	 * Cheks if user with exact login is exists.
	 *
	 * @return true if exists
	 */

	boolean isLoginExists(String login);

	/**
	 * Cheks if user with exact email is exists.
	 *
	 * @return true if exists
	 */
	boolean isEmailExists(String email);

}
