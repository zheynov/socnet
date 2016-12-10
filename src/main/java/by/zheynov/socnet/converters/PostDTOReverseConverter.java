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
	/**
	 * Converts from dto to entity.
	 *
	 * @param postDTO the dto
	 *
	 * @return the entity
	 */
	@Override
	public PostEntity convert(final PostDTO postDTO)
	{

		if (postDTO == null)
		{
			return null;
		}

		PostEntity postEntity = new PostEntity();

		//Sender's profile
		ProfileEntity senderProfileEntity = new ProfileEntity();
		ProfileDTO senderProfileDTO = postDTO.getSenderProfileDTO();
		senderProfileEntity.setId(senderProfileDTO.getProfileID());
		senderProfileEntity.setFirstname(senderProfileDTO.getFirstname());
		senderProfileEntity.setLastname(senderProfileDTO.getLastname());
		senderProfileEntity.setEmail(senderProfileDTO.getEmail());
		senderProfileEntity.setAge(senderProfileDTO.getAge());
		senderProfileEntity.setBirthDate(senderProfileDTO.getBirthDate());
		senderProfileEntity.setSex(senderProfileDTO.getSex());
		senderProfileEntity.setCity(senderProfileDTO.getCity());
		senderProfileEntity.setPhoneNumber(senderProfileDTO.getPhoneNumber());

		// Wall owner profile
		ProfileEntity wallOwnerProfileEntity = new ProfileEntity();
		ProfileDTO wallOwnerProfileDTO = postDTO.getWallOwnerProfileDTO();
		wallOwnerProfileEntity.setId(wallOwnerProfileDTO.getProfileID());
		wallOwnerProfileEntity.setFirstname(wallOwnerProfileDTO.getFirstname());
		wallOwnerProfileEntity.setLastname(wallOwnerProfileDTO.getLastname());
		wallOwnerProfileEntity.setEmail(wallOwnerProfileDTO.getEmail());
		wallOwnerProfileEntity.setAge(wallOwnerProfileDTO.getAge());
		wallOwnerProfileEntity.setBirthDate(wallOwnerProfileDTO.getBirthDate());
		wallOwnerProfileEntity.setSex(wallOwnerProfileDTO.getSex());
		wallOwnerProfileEntity.setCity(wallOwnerProfileDTO.getCity());
		wallOwnerProfileEntity.setPhoneNumber(wallOwnerProfileDTO.getPhoneNumber());

		//Photo data setting
		postEntity.setPostID(postDTO.getPostID());

		postEntity.setWallOwnerProfile(wallOwnerProfileEntity);
		postEntity.setProfileSender(senderProfileEntity);

		postEntity.setText(postDTO.getText());
		postEntity.setPostDate(postDTO.getPostDate());

		return postEntity;
	}
}