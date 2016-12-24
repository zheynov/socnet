package by.zheynov.socnet.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import by.zheynov.socnet.dto.FriendDTO;
import by.zheynov.socnet.entity.FriendEntity;
import by.zheynov.socnet.entity.ProfileEntity;

/**
 * FriendDTOReverseConverter class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.converters
 */
@Component
public class FriendDTOReverseConverter implements Converter<FriendDTO, FriendEntity>
{
	/**
	 * Converts FriendDTO object to FriendEntity object.
	 *
	 * @param friendDTO the dto
	 *
	 * @return the profileEntity
	 */
	public FriendEntity convert(final FriendDTO friendDTO)
	{
		if (friendDTO == null)
		{
			return null;
		}

		final FriendEntity friendEntity = new FriendEntity();

		ProfileEntity profileEntityMainProfile = new ProfileEntity();

		profileEntityMainProfile.setId(friendDTO.getProfileDTO().getProfileID());
		profileEntityMainProfile.setFirstname(friendDTO.getProfileDTO().getFirstname());
		profileEntityMainProfile.setLastname(friendDTO.getProfileDTO().getLastname());
		profileEntityMainProfile.setEmail(friendDTO.getProfileDTO().getEmail());
		profileEntityMainProfile.setAge(friendDTO.getProfileDTO().getAge());
		profileEntityMainProfile.setBirthDate(friendDTO.getProfileDTO().getBirthDate());
		profileEntityMainProfile.setSex(friendDTO.getProfileDTO().getSex());
		profileEntityMainProfile.setCity(friendDTO.getProfileDTO().getCity());
		profileEntityMainProfile.setPhoneNumber(friendDTO.getProfileDTO().getPhoneNumber());
		friendEntity.setCurrentProfileEntity(profileEntityMainProfile);

		ProfileEntity profileEntityFriendProfile = new ProfileEntity();

		profileEntityFriendProfile.setId(friendDTO.getFriendProfileDTO().getProfileID());
		profileEntityFriendProfile.setFirstname(friendDTO.getFriendProfileDTO().getFirstname());
		profileEntityFriendProfile.setLastname(friendDTO.getFriendProfileDTO().getLastname());
		profileEntityFriendProfile.setEmail(friendDTO.getFriendProfileDTO().getEmail());
		profileEntityFriendProfile.setAge(friendDTO.getFriendProfileDTO().getAge());
		profileEntityFriendProfile.setBirthDate(friendDTO.getFriendProfileDTO().getBirthDate());
		profileEntityFriendProfile.setSex(friendDTO.getFriendProfileDTO().getSex());
		profileEntityFriendProfile.setCity(friendDTO.getFriendProfileDTO().getCity());
		profileEntityFriendProfile.setPhoneNumber(friendDTO.getFriendProfileDTO().getPhoneNumber());
		friendEntity.setFriendProfileEntity(profileEntityFriendProfile);

		friendEntity.setId(friendDTO.getId());
		friendEntity.setStatus(friendDTO.getStatus());

		return friendEntity;
	}
}