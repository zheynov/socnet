package by.zheynov.socnet.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
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

		ProfileEntity profileEntity = new ProfileEntity();
		profileEntity.setId(friendDTO.getProfileDTO().getProfileID());
		profileEntity.setFirstname(friendDTO.getProfileDTO().getFirstname());
		profileEntity.setLastname(friendDTO.getProfileDTO().getLastname());
		profileEntity.setEmail(friendDTO.getProfileDTO().getEmail());
		profileEntity.setAge(friendDTO.getProfileDTO().getAge());
		profileEntity.setBirthDate(friendDTO.getProfileDTO().getBirthDate());
		profileEntity.setSex(friendDTO.getProfileDTO().getSex());
		profileEntity.setCity(friendDTO.getProfileDTO().getCity());
		profileEntity.setPhoneNumber(friendDTO.getProfileDTO().getPhoneNumber());

		friendEntity.setId(friendDTO.getId());
		friendEntity.setCurrentProfileEntity(profileEntity);
		friendEntity.setFriendProfileEntity(friendDTO.getFriendProfileId());
		friendEntity.setStatus(friendDTO.getStatus());

		return friendEntity;
	}
}