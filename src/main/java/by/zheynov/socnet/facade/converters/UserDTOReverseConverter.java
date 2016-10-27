package by.zheynov.socnet.facade.converters;

import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.entity.UserEntity;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Redlaw on 22.10.2016.
 */

@Component
public class UserDTOReverseConverter implements Converter<UserEntity, UserDTO>
{

	public UserDTO convert(UserEntity userEntity)
	{
		if (userEntity != null)
		{
			UserDTO userDTO = new UserDTO();

			userDTO.setId(userEntity.getId());
			userDTO.setFirstName(userEntity.getFirstName());
			userDTO.setLastName(userEntity.getLastName());
			userDTO.setEmail(userEntity.getEmail());
			userDTO.setLogin(userEntity.getLogin());
			userDTO.setPassword(userEntity.getPassword());

			return userDTO;
		}
		return null;
	}
}
