package by.zheynov.socnet.facade.impl;

import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.entity.UserEntity;
import by.zheynov.socnet.facade.UserFacade;
import by.zheynov.socnet.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import java.util.ArrayList;
import java.util.List;


public class UserFacadeImpl implements UserFacade
{
	@Autowired
	private UserService       userService;
	@Autowired
	private ConversionService conversionService;

	public void createUser(UserDTO userDTO)
	{
		userService.createUser(conversionService.convert(userDTO, UserEntity.class));
	}

	public void updateUser(UserDTO userEntity)
	{
	}

	public void deleteUser(UserDTO userEntity)
	{
	}

	public UserEntity getUserByLogin(String login) {
		return null;
	}

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

	public boolean isLoginExists(String login) {
		return userService.isLoginExists(login);
	}

	public boolean isUserPasswpodlCorrect(UserDTO userDTO) {
		return userService.isPasswpodlCorrect(userDTO);
	}

	public boolean isEmailExists(String email) {
		return userService.isEmailExists(email);
	}
}
