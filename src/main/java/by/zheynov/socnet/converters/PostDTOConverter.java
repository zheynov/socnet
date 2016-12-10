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
	/**
	 * * Converts from entity to dto.
	 *
	 * @param postEntity the entity
	 *
	 * @return the dto
	 */
	@Override
	public PostDTO convert(final PostEntity postEntity)
	{
		if (postEntity == null)
		{
			return null;
		}

		PostDTO postDTO = new PostDTO();

		//Sender's  profile
		ProfileEntity senderProfileEntity = postEntity.getProfileSender();
		ProfileDTO senderProfileDTO = new ProfileDTO();
		senderProfileDTO.setProfileID(senderProfileEntity.getId());
		senderProfileDTO.setFirstname(senderProfileEntity.getFirstname());
		senderProfileDTO.setLastname(senderProfileEntity.getLastname());
		senderProfileDTO.setEmail(senderProfileEntity.getEmail());
		senderProfileDTO.setBirthDate(senderProfileEntity.getBirthDate());
		senderProfileDTO.setAge(senderProfileEntity.getAge());
		senderProfileDTO.setSex(senderProfileEntity.getSex());
		senderProfileDTO.setCity(senderProfileEntity.getCity());
		senderProfileDTO.setPhoneNumber(senderProfileEntity.getPhoneNumber());

		//Wall owner profile
		ProfileEntity wallOwnerProfileEntity = postEntity.getProfileSender();
		ProfileDTO wallownerProfileDTO = new ProfileDTO();
		wallownerProfileDTO.setProfileID(wallOwnerProfileEntity.getId());
		wallownerProfileDTO.setFirstname(wallOwnerProfileEntity.getFirstname());
		wallownerProfileDTO.setLastname(wallOwnerProfileEntity.getLastname());
		wallownerProfileDTO.setEmail(wallOwnerProfileEntity.getEmail());
		wallownerProfileDTO.setBirthDate(wallOwnerProfileEntity.getBirthDate());
		wallownerProfileDTO.setAge(wallOwnerProfileEntity.getAge());
		wallownerProfileDTO.setSex(wallOwnerProfileEntity.getSex());
		wallownerProfileDTO.setCity(wallOwnerProfileEntity.getCity());
		wallownerProfileDTO.setPhoneNumber(wallOwnerProfileEntity.getPhoneNumber());

		//Setting post data
		postDTO.setPostID(postEntity.getPostID());
		postDTO.setSenderProfileDTO(senderProfileDTO);
		postDTO.setWallOwnerProfileDTO(wallownerProfileDTO);
		postDTO.setText(postEntity.getText());
		postDTO.setPostDate(postEntity.getPostDate());
		postDTO.setPhotoFileName(postEntity.getPhotoFileName());

		return postDTO;
	}
}