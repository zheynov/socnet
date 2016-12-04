package by.zheynov.socnet.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import by.zheynov.socnet.dto.PostDTO;
import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.entity.PostEntity;
import by.zheynov.socnet.entity.ProfileEntity;

/**
 * PostDTOConverter class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.converters
 */
@Component
public class PostDTOConverter implements Converter<PostEntity, PostDTO>
{
	@Override
	public PostDTO convert(final PostEntity postEntity)
	{
		if (postEntity == null)
		{
			return null;
		}

		PostDTO postDTO = new PostDTO();

		postDTO.setText(postEntity.getText());
		postDTO.setPhotoFileName(postEntity.getPhotoFileName());
		postDTO.setPostDate(postEntity.getPostDate());
		postDTO.setPostID(postEntity.getPostID());

		ProfileEntity profileEntity = postEntity.getProfileEntity();

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

		postDTO.setProfileDTO(profileDTO);

		return postDTO;
	}
}