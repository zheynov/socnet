package by.zheynov.socnet.facade;

import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.entity.UserEntity;

import java.util.List;

/**
 * User Facade interface.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.facade
 */
public interface UserFacade
{
	/**
	 * Saves.
	 *
	 * @param userDTO the dto
	 */
	void createUser(UserDTO userDTO);

	/**
	 * Updates.
	 *
	 * @param userDTO the dto
	 */
	void updateUser(UserDTO userDTO);

	/**
	 * Deletes.
	 *
	 * @param userDTO the dto
	 */
	void deleteUser(UserDTO userDTO);

	UserEntity getUserByLogin(String login);

	/**
	 * Retrieves a list of UserDTO objects.
	 *
	 * @return the List<UserDTO>
	 */
	List<UserDTO> getAllTheUsers();

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
