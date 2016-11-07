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
 * ProfileDTOConverter.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.converters
 */

@Component
public class ProfileDTOConverter implements Converter<ProfileEntity, ProfileDTO>
{

	/**
	 * Converts ProfileEntity object to ProfileDTO object.
	 *
	 * @param profileEntity the profileEntity
	 *
	 * @return the profileDTO
	 */
	public ProfileDTO convert(final ProfileEntity profileEntity)
	{

		if (profileEntity == null)
		{
			return null;
		}

		ProfileDTO profileDTO = new ProfileDTO();

		profileDTO.setProfileID(profileEntity.getId());
		profileDTO.setFirstname(profileEntity.getFirstname());
		profileDTO.setLastname(profileEntity.getLastname());
		profileDTO.setEmail(profileEntity.getEmail());
		profileDTO.setBirthDate(profileEntity.getBirthDate());
		profileDTO.setAge(profileEntity.getAge());
		profileDTO.setSex(profileEntity.getSex());
		profileDTO.setCity(profileEntity.getCity());
		profileDTO.setPhoneNumber(profileEntity.getPhoneNumber());

		UserDTO userDTO = new UserDTO();
		UserEntity userEntity = profileEntity.getUserEntity();

		userDTO.setProfileDTO(profileDTO);
		userDTO.setId(userEntity.getId());
		userDTO.setUsername(userEntity.getUsername());
		userDTO.setPassword(userEntity.getPassword());
		userDTO.setEmail(userEntity.getEmail());
		userDTO.setEnabled(userEntity.isEnabled());

		profileDTO.setUserDTO(userDTO);

		return profileDTO;
	}
}
