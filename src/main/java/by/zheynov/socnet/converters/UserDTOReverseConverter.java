package by.zheynov.socnet.converters;


import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.entity.PostEntity;
import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.entity.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * UserDTOReverseConverter.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.converters
 */

@Component
public class UserDTOReverseConverter implements Converter<UserDTO, UserEntity>
{
	/**
	 * Converts to UserDTO object to UserEntity.
	 *
	 * @param userDTO the userDTO
	 *
	 * @return the userEntity
	 */
	public UserEntity convert(final UserDTO userDTO)
	{
		UserEntity userEntity = new UserEntity();

		userEntity.setEnabled(userDTO.isEnabled());
		userEntity.setId(userDTO.getId());
		userEntity.setEmail(userDTO.getEmail());
		userEntity.setUsername(userDTO.getUsername());
		userEntity.setPassword(userDTO.getPassword());
		userEntity.setEnabled(userDTO.isEnabled());

		return userEntity;
	}


}
