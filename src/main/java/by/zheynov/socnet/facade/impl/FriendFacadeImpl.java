package by.zheynov.socnet.facade.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

import by.zheynov.socnet.dto.FriendDTO;
import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.entity.FriendEntity;
import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.facade.FriendFacade;
import by.zheynov.socnet.service.FriendService;

/**
 * .
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.facade.impl
 */
public class FriendFacadeImpl implements FriendFacade
{
	@Autowired
	private FriendService     friendService;
	@Autowired
	private ConversionService conversionService;

	/**
	 * Adds new friend to user's friends set using their profiles.
	 *
	 * @param currentProfileDTO the dto
	 * @param newFriend         the dto
	 */

	public void addFriend(final ProfileDTO currentProfileDTO, final ProfileDTO newFriend)
	{
		ProfileEntity currentProfileEntity = conversionService.convert(currentProfileDTO, ProfileEntity.class);
		ProfileEntity newFriendProfileEntity = conversionService.convert(newFriend, ProfileEntity.class);
		friendService.addFriend(currentProfileEntity, newFriendProfileEntity);
	}

	/**
	 * Retrieves a list of Pending friend request.
	 *
	 * @param currentLoggedUserProfileId the Id
	 *
	 * @return list of dto's
	 */
	public Set<FriendDTO> getAllThePendingFriendRequest(final Long currentLoggedUserProfileId)
	{
		Set<FriendDTO> allTheProfilesDTO = new HashSet<FriendDTO>();

		for (FriendEntity friendEntity : friendService.getAllThePendingFriendRequest(currentLoggedUserProfileId))
		{
			final FriendDTO friendProfileDTO = conversionService.convert(friendEntity, FriendDTO.class);
			allTheProfilesDTO.add(friendProfileDTO);
		}
		return allTheProfilesDTO;
	}

	/**
	 * Retrieves a list of FriendDTO objects with status PENDING_REQUEST.
	 *
	 * @return the List<FriendDTO>
	 */
	public List<FriendDTO> getAllThePendingRequests()
	{
		List<FriendDTO> allPendingFriends = new ArrayList<>();

		for (FriendEntity friendEntity : friendService.getAllThePendingRequests())
		{
			allPendingFriends.add(conversionService.convert(friendEntity, FriendDTO.class));
		}
		return allPendingFriends;
	}

	/**
	 * Deletes a frend with friend's frendProfileId.
	 *
	 * @param loggedUserProfileId the Id
	 * @param frendProfileId      the Id
	 */
	public void deleteFriend(final Long loggedUserProfileId, final Long frendProfileId)
	{
		friendService.deleteFriend(loggedUserProfileId, frendProfileId);
	}

	/**
	 * loggedUserProfileId approves frend request from frendProfileId .
	 *
	 * @param loggedUserProfileId the Id
	 * @param frendProfileId      the Id
	 */
	public void approveFriendRequest(final Long loggedUserProfileId, final Long frendProfileId)
	{
		friendService.approveFriendRequest(loggedUserProfileId, frendProfileId);
	}

	/**
	 * loggedUserProfileId rejects frend request from frendProfileId .
	 *
	 * @param loggedUserProfileId the Id
	 * @param frendProfileId      the Id
	 */
	public void rejectFriendRequest(final Long loggedUserProfileId, final Long frendProfileId)
	{
		friendService.rejectFriendRequest(loggedUserProfileId, frendProfileId);
	}
}