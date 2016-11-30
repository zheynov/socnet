package by.zheynov.socnet.facade.impl;

import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.entity.RegistrationStatus;
import by.zheynov.socnet.entity.UserEntity;
import by.zheynov.socnet.facade.UserFacade;
import by.zheynov.socnet.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * User facade implementation.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.facade
 */
@Component("userFacade")
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
	 * Checks if user with such username or email is exists.
	 *
	 * @param username the username
	 * @param email    the email
	 *
	 * @return registration status
	 */
	public RegistrationStatus registrationStatus(final String username, final String email)
	{
		List<UserDTO> allTheDTOUsers = new ArrayList<UserDTO>(); // list of users

		for (UserEntity userEntity : userService.getUserByUsernameOrEmail(username, email))
		{
			final UserDTO userDTO = conversionService.convert(userEntity, UserDTO.class);
			allTheDTOUsers.add(userDTO);
		}

		if (allTheDTOUsers.size() > 0)
		{
			UserDTO userDTO = allTheDTOUsers.get(0);

			if (userDTO.getEmail().equalsIgnoreCase(email))
			{
				return RegistrationStatus.EMAIL_EXISTS;
			}
			else if (userDTO.getUsername().equalsIgnoreCase(username))
			{
				return RegistrationStatus.USERNAME_EXISTS;
			}
		}
		return RegistrationStatus.FREE; // user is absent in database
	}
}
