package by.zheynov.socnet.converters;

import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.entity.ProfileEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * ProfileDTOReverseConverter.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.converters
 */

@Component
public class ProfileDTOReverseConverter implements Converter<ProfileDTO, ProfileEntity>
{
	/**
	 * Converts ProfileDTO object to ProfileEntity object.
	 *
	 * @param profileDTO the profileDTO
	 *
	 * @return the profileEntity
	 */
	public ProfileEntity convert(final ProfileDTO profileDTO)
	{

		if (profileDTO == null)
		{
			return null;
		}

		final ProfileEntity profileEntity = new ProfileEntity();

		profileEntity.setId(profileDTO.getProfileID());
		profileEntity.setFirstname(profileDTO.getFirstname());
		profileEntity.setLastname(profileDTO.getLastname());
		profileEntity.setEmail(profileDTO.getEmail());
		profileEntity.setAge(profileDTO.getAge());
		profileEntity.setBirthDate(profileDTO.getBirthDate());
		profileEntity.setSex(profileDTO.getSex());
		profileEntity.setCity(profileDTO.getCity());
		profileEntity.setPhoneNumber(profileDTO.getPhoneNumber());

		return profileEntity;
	}
}
