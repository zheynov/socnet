package by.zheynov.socnet.facade;

import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.entity.RegistrationStatus;

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
	 * Checks if user with such username or email is exists.
	 *
	 * @param username the username
	 * @param email    the email
	 *
	 * @return registration status
	 */
	RegistrationStatus registrationStatus(String username, String email);

}
