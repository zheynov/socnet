package by.zheynov.socnet.dao;

import by.zheynov.socnet.entity.UserEntity;

import java.util.List;

/**
 * User Dao interface.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao
 */

public interface UserDao
{

	/**
	 * Saves.
	 *
	 * @param user the entity
	 *
	 * @return the entity
	 */
	UserEntity createUser(UserEntity user);

	/**
	 * Updates.
	 *
	 * @param user the entity
	 */
	void updateUser(UserEntity user);

	/**
	 * Deletes.
	 *
	 * @param user the entity
	 */
	void deleteUser(UserEntity user);

	/**
	 * Finds UserEntity By login.
	 *
	 * @param login the login
	 *
	 * @return the UserEntity
	 */
	UserEntity getUserByUsername(String login);

	/**
	 * Retrieves a list of userEntity objects.
	 *
	 * @return the List<UserEntity>
	 */
	List<UserEntity> getAllTheUsers();

	/**
	 * Cheks if user with exact login is exists.
	 *
	 * @param login the login
	 * @return true if exists
	 */
	boolean isLoginExists(String login);

	/**
	 * Cheks if user with exact email is exists.
	 *
	 * @param email the email
	 * @return true if exists
	 */
	boolean isEmailExists(String email);

}
