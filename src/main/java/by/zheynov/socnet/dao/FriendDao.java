package by.zheynov.socnet.dao;

import java.util.List;

import by.zheynov.socnet.entity.FriendEntity;
import by.zheynov.socnet.entity.ProfileEntity;

/**
 * FriendDao interface.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao
 */
public interface FriendDao
{

	/**
	 * Adds a friend.
	 *
	 * @param currentProfile the entity
	 * @param newFriend      the entity
	 */
	void addFriend(ProfileEntity currentProfile, ProfileEntity newFriend);

	/**
	 * Retrieves a list of FriendEntity objects for logged user with profileId.
	 *
	 * @param profileId the Id
	 *
	 * @return the List<friendEntity>
	 */
	List<FriendEntity> getAllTheFriends(Long profileId);

	/**
	 * Retrieves a list of FriendEntity objects for user with profileId.
	 *
	 * @param profileId the Id
	 *
	 * @return the List<friendEntity>
	 */
	List<FriendEntity> getAllTheFriendsForFriendUser(Long profileId);

	/**
	 * Retrieves a list of FriendEntity objects with status PENDING_REQUEST.
	 *
	 * @return the List<friendEntity>
	 */
	List<FriendEntity> getAllThePendingRequests();

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

	/**
	 * Gets FriendEntity from database.
	 *
	 * @param friendId the id
	 *
	 * @return friend entity
	 */
	FriendEntity getById(Long friendId);
}