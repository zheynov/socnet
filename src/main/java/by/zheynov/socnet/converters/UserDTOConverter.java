package by.zheynov.socnet.converters;

import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.entity.UserEntity;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * UserDTOConverter.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.converters
 */
@Component
public class UserDTOConverter implements Converter<UserEntity, UserDTO>
{
	/**
	 * Converts UserEntity object to UserDTO.
	 *
	 * @param userEntity the userEntity
	 *
	 * @return the userDTO
	 */
	public UserDTO convert(final UserEntity userEntity)
	{
		if (userEntity != null)
		{

			UserDTO userDTO = new UserDTO();

			userDTO.setEnabled(userEntity.isEnabled());
			userDTO.setId(userEntity.getId());
			userDTO.setEmail(userEntity.getEmail());
			userDTO.setUsername(userEntity.getUsername());
			userDTO.setPassword(userEntity.getPassword());
			userDTO.setProfileID(userEntity.getProfileEntity().getId());

			return userDTO;
		}
		return null;
	}
}
