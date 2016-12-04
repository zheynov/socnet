package by.zheynov.socnet.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import by.zheynov.socnet.dto.PhotoDTO;
import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.entity.PhotoEntity;
import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.entity.UserEntity;

/**
 * PhotoDTOConverter class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.converters
 */
@Component
public class PhotoDTOConverter implements Converter<PhotoEntity, PhotoDTO>
{
	@Override
	public PhotoDTO convert(final PhotoEntity photoEntity)
	{
		if (photoEntity == null)
		{
			return null;
		}

		PhotoDTO photoDTO = new PhotoDTO();

		if (photoEntity.getProfileEntity() != null)
		{
			ProfileEntity profileEntity = photoEntity.getProfileEntity();

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

			photoDTO.setProfileDTO(profileDTO);
		}
		photoDTO.setId(photoEntity.getId());
		photoDTO.setPhotoFileName(photoEntity.getPhotoFileName());

		return photoDTO;
	}
}