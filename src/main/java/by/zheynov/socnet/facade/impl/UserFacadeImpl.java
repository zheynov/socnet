package by.zheynov.socnet.facade.impl;

import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.entity.UserEntity;
import by.zheynov.socnet.facade.UserFacade;
import by.zheynov.socnet.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import java.util.ArrayList;
import java.util.List;

/**
 * User facade implementation.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.facade
 */

public class UserFacadeImpl implements UserFacade
{
	@Autowired
	private UserService       userService;
	@Autowired
	private ConversionService conversionService;

	/**
	 * Saves user to database.
	 *
	 * @param userDTO the dto
	 */
	public void createUser(final UserDTO userDTO)
	{
		userService.createUser(conversionService.convert(userDTO, UserEntity.class));
	}

	/**
	 * Updates the user in database.
	 *
	 * @param userDTO the dto
	 */
	public void updateUser(final UserDTO userDTO)
	{
		userService.updateUser(conversionService.convert(userDTO, UserEntity.class));
	}

	/**
	 * Deletes user from database.
	 *
	 * @param userDTO the dto
	 */
	public void deleteUser(final UserDTO userDTO)
	{
		userService.deleteUser(conversionService.convert(userDTO, UserEntity.class));
	}

	/**
	 * Gets user from database by its username.
	 *
	 * @param username the username
	 *
	 * @return the dto
	 */
	public UserDTO getUserByUsername(final String username)
	{
		return conversionService.convert(userService.getUserByUsername(username), UserDTO.class);
	}

	/**
	 * Gets a list of users.
	 *
	 * @return List<UserDTO>
	 */
	public List<UserDTO> getAllTheUsers()
	{

		List<UserDTO> allTheDTOUsers = new ArrayList<UserDTO>();
		for (UserEntity userEntity : userService.getAllTheUsers())
		{
			final UserDTO convert = conversionService.convert(userEntity, UserDTO.class);
			allTheDTOUsers.add(convert);
		}
		return allTheDTOUsers;
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
		return userService.isUsernameExists(username);
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
		return userService.isEmailExists(email);
	}
}
