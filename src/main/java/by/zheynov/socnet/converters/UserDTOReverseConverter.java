package by.zheynov.socnet.converters;

import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.dto.UserDTO;

import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.entity.RoleEntity;
import by.zheynov.socnet.entity.UserEntity;

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

		ProfileEntity profileEntity = new ProfileEntity();
		ProfileDTO profileDTO = userDTO.getProfileDTO();

		if (profileDTO != null)
		{
			profileEntity.setId(profileDTO.getProfileID());

			profileEntity.setFirstname(profileDTO.getFirstname());
			profileEntity.setLastname(profileDTO.getLastname());
			profileEntity.setEmail(profileDTO.getEmail());
			profileEntity.setAge(profileDTO.getAge());
			profileEntity.setBirthDate(profileDTO.getBirthDate());
			profileEntity.setSex(profileDTO.getSex());
			profileEntity.setCity(profileDTO.getCity());
			profileEntity.setPhoneNumber(profileDTO.getPhoneNumber());

			userEntity.setProfileEntity(profileEntity);
		}

		if (userDTO.getRoleDTO() != null)
		{
			RoleEntity roleEntity = new RoleEntity();
			roleEntity.setRole(userDTO.getRoleDTO().getRole());
			roleEntity.setId(userDTO.getRoleDTO().getId());
			userEntity.setRoleEntity(roleEntity);
		}

		return userEntity;
	}
}
