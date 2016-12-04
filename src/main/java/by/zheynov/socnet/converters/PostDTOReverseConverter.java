package by.zheynov.socnet.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import by.zheynov.socnet.dto.PostDTO;
import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.entity.PostEntity;
import by.zheynov.socnet.entity.ProfileEntity;

/**
 * PostDTOReverseConverter class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.converters
 */
@Component
public class PostDTOReverseConverter implements Converter<PostDTO, PostEntity>
{
	@Override
	public PostEntity convert(final PostDTO postDTO)
	{

		if (postDTO == null)
		{
			return null;
		}

		PostEntity postEntity = new PostEntity();

		postEntity.setPostID(postDTO.getPostID());
		postEntity.setText(postDTO.getText());
		postEntity.setPostDate(postDTO.getPostDate());
		postEntity.setPhotoFileName(postDTO.getPhotoFileName());

		ProfileEntity profileEntity = new ProfileEntity();

		ProfileDTO profileDTO = postDTO.getProfileDTO();

		profileEntity.setId(profileDTO.getProfileID());
		profileEntity.setFirstname(profileDTO.getFirstname());
		profileEntity.setLastname(profileDTO.getLastname());
		profileEntity.setEmail(profileDTO.getEmail());
		profileEntity.setAge(profileDTO.getAge());
		profileEntity.setBirthDate(profileDTO.getBirthDate());
		profileEntity.setSex(profileDTO.getSex());
		profileEntity.setCity(profileDTO.getCity());
		profileEntity.setPhoneNumber(profileDTO.getPhoneNumber());

		postEntity.setProfileEntity(profileEntity);

		return postEntity;
	}
}