package by.zheynov.socnet.converters;

import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.entity.UserEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
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
			userDTO.setEnabled(userEntity.isEnabled());

			ProfileEntity profileEntity = userEntity.getProfileEntity();
			ProfileDTO profileDTO = new ProfileDTO();

			profileDTO.setUserDTO(userDTO);
			profileDTO.setAge(profileEntity.getAge());
			profileDTO.setBirthDate(profileEntity.getBirthDate());
			profileDTO.setCity(profileEntity.getCity());
			profileDTO.setEmail(profileEntity.getEmail());
			profileDTO.setFirstname(profileEntity.getFirstname());
			profileDTO.setLastname(profileEntity.getLastname());
			profileDTO.setPhoneNumber(profileEntity.getPhoneNumber());
			profileDTO.setProfileID(profileEntity.getId());
			profileDTO.setSex(profileEntity.getSex());

			userDTO.setProfileDTO(profileDTO);

			return userDTO;
		} return null;
	}
}
