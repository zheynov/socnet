package by.zheynov.socnet.converters;

import org.springframework.core.convert.converter.Converter;

import by.zheynov.socnet.dto.FriendDTO;
import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.entity.FriendEntity;
import by.zheynov.socnet.entity.ProfileEntity;

/**
 * FriendDTOConverter class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.converters
 */
public class FriendDTOConverter implements Converter<FriendEntity, FriendDTO>
{
	/**
	 * Converts FriendEntity object to FriendDTO object.
	 *
	 * @param friendEntity the entity
	 *
	 * @return the profileDTO
	 */
	public FriendDTO convert(final FriendEntity friendEntity)
	{
		if (friendEntity == null)
		{
			return null;
		}

		FriendDTO friendDTO = new FriendDTO();

		ProfileEntity profileEntity = friendEntity.getCurrentProfileEntity();
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

		ProfileEntity profileEntityForFriend = friendEntity.getFriendProfileEntity();
		ProfileDTO profileDTOForFriend = new ProfileDTO();
		profileDTOForFriend.setProfileID(profileEntityForFriend.getId());
		profileDTOForFriend.setFirstname(profileEntityForFriend.getFirstname());
		profileDTOForFriend.setLastname(profileEntityForFriend.getLastname());
		profileDTOForFriend.setEmail(profileEntityForFriend.getEmail());
		profileDTOForFriend.setBirthDate(profileEntityForFriend.getBirthDate());
		profileDTOForFriend.setAge(profileEntityForFriend.getAge());
		profileDTOForFriend.setSex(profileEntityForFriend.getSex());
		profileDTOForFriend.setCity(profileEntityForFriend.getCity());
		profileDTOForFriend.setPhoneNumber(profileEntityForFriend.getPhoneNumber());

		friendDTO.setProfileDTO(profileDTO);
		friendDTO.setFriendProfileDTO(profileDTOForFriend);

		friendDTO.setId(friendEntity.getId());
		friendDTO.setStatus(friendEntity.getStatus());

		return friendDTO;
	}
}