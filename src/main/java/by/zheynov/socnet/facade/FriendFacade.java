package by.zheynov.socnet.facade;

import java.util.List;
import java.util.Set;

import by.zheynov.socnet.dto.FriendDTO;
import by.zheynov.socnet.dto.ProfileDTO;

/**
 * FriendFacade interface.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.facade
 */
public interface FriendFacade
{
	/**
	 * Adds new friend to user's friends set using their profiles.
	 *
	 * @param currentProfileDTO the dto
	 * @param newFriend         the dto
	 */
	void addFriend(ProfileDTO currentProfileDTO, ProfileDTO newFriend);

	/**
	 * Retrieves a list of Pending friend request.
	 *
	 * @param currentLoggedUserProfileId the Id
	 *
	 * @return list of dto's
	 */
	Set<FriendDTO> getAllThePendingFriendRequest(Long currentLoggedUserProfileId);

	/**
	 * Retrieves a list of FriendDTO objects with status PENDING_REQUEST.
	 *
	 * @return the List<FriendDTO>
	 */
	List<FriendDTO> getAllThePendingRequests();

	/**
	 * Deletes a frend with friend's frendProfileId.
	 *
	 * @param loggedUserProfileId the Id
	 * @param frendProfileId      the Id
	 */
	void deleteFriend(Long loggedUserProfileId, Long frendProfileId);

	/**
	 * loggedUserProfileId approves frend request from frendProfileId .
	 *
	 * @param loggedUserProfileId the Id
	 * @param frendProfileId      the Id
	 */
	void approveFriendRequest(Long loggedUserProfileId, Long frendProfileId);

	/**
	 * loggedUserProfileId rejects frend request from frendProfileId .
	 *
	 * @param loggedUserProfileId the Id
	 * @param frendProfileId      the Id
	 */
	void rejectFriendRequest(Long loggedUserProfileId, Long frendProfileId);
}