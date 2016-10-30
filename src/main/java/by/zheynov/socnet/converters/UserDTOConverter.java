package by.zheynov.socnet.converters;

import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.entity.UserEntity;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by Redlaw on 22.10.2016.
 */

@Component
public class UserDTOConverter implements Converter<UserEntity, UserDTO>
{
	public UserDTO convert(UserEntity userEntity)
	{
		if (userEntity != null)
		{

			UserDTO userDTO = new UserDTO();

			userDTO.setId(userEntity.getId());
			userDTO.setEmail(userEntity.getEmail());
			userDTO.setUsername(userEntity.getUsername());
			userDTO.setPassword(userEntity.getPassword());

			return userDTO;
		}
		return null;
	}
}
