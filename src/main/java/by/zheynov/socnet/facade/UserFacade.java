package by.zheynov.socnet.facade;

import by.zheynov.socnet.dto.UserDTO;

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

	/**
	 * Gets UserDTO object by its username.
	 *
	 * @param username the username
	 *
	 * @return the dto
	 */
	UserDTO getUserByUsername(String username);

	/**
	 * Retrieves a list of UserDTO objects.
	 *
	 * @return the List<UserDTO>
	 */
	List<UserDTO> getAllTheUsers();

	/**
	 * Cheks if user with exact login is exists.
	 *
	 * @param username the username
	 *
	 * @return true if exists
	 */
	boolean isUsernameExists(String username);

	/**
	 * Cheks if user with exact email is exists.
	 *
	 * @param email the email
	 *
	 * @return true if exists
	 */
	boolean isEmailExists(String email);
}
