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
	 * Finds UserEntity By username.
	 *
	 * @param username the username
	 *
	 * @return the UserEntity
	 */
	UserEntity getUserByUsername(String username);

	/**
	 * Retrieves a list of userEntity objects.
	 *
	 * @return the List<UserEntity>
	 */
	List<UserEntity> getAllTheUsers();

	/**
	 * Returns a list of users with such email or username.
	 *
	 * @param username the username
	 * @param email    the email
	 *
	 * @return list of users
	 */
	List<UserEntity> getUserByUsernameOrEmail(String username, String email);

	/**
	 * Gets UserEntity from database.
	 *
	 * @param userId the id
	 *
	 * @return user entity
	 */
	UserEntity getById(Long userId);

}
