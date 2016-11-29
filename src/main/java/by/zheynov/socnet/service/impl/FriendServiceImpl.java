package by.zheynov.socnet.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import by.zheynov.socnet.dao.FriendDao;
import by.zheynov.socnet.entity.FriendEntity;
import by.zheynov.socnet.entity.FriendRequestApprovalStatus;
import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.service.FriendService;

/**
 * FriendServiceImpl class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.facade.impl
 */
public class FriendServiceImpl implements FriendService
{
	private FriendDao friendDao;

	/**
	 * Adds new friend to user's friends set using their profiles.
	 *
	 * @param currentProfile the entity
	 * @param newFriend      the entity
	 */
	@Transactional
	public void addFriend(final ProfileEntity currentProfile, final ProfileEntity newFriend)
	{
		friendDao.addFriend(currentProfile, newFriend);
	}

	/**
	 * Deletes a frend with friend's frendProfileId.
	 *
	 * @param loggedUserProfileId the Id
	 * @param frendProfileId      the Id
	 */
	@Transactional
	public void deleteFriend(final Long loggedUserProfileId, final Long frendProfileId)
	{
		friendDao.deleteFriend(loggedUserProfileId, frendProfileId);
	}

	/**
	 * Retrieves a list of Pending friend request.
	 *
	 * @param currentLoggedUserProfileId the Id
	 *
	 * @return list of entities
	 */
	@Transactional
	public List<FriendEntity> getAllThePendingFriendRequest(final Long currentLoggedUserProfileId)
	{
		List<FriendEntity> result = new ArrayList<FriendEntity>();

		for (FriendEntity friendEntity : friendDao.getAllTheFriendsForFriendUser(currentLoggedUserProfileId))
		{
			if (friendEntity.getStatus() == FriendRequestApprovalStatus.PENDING_REQUEST)
			{
				result.add(friendEntity);
			}
		}
		return result;
	}

	/**
	 * Retrieves a list of FriendEntity objects with status PENDING_REQUEST.
	 *
	 * @return the List<friendEntity>
	 */
	@Transactional
	public List<FriendEntity> getAllThePendingRequests()
	{
		return friendDao.getAllThePendingRequests();
	}

	/**
	 * loggedUserProfileId approves frend request from frendProfileId .
	 *
	 * @param loggedUserProfileId the Id
	 * @param frendProfileId      the Id
	 */
	@Transactional
	public void approveFriendRequest(final Long loggedUserProfileId, final Long frendProfileId)
	{
		friendDao.approveFriendRequest(loggedUserProfileId, frendProfileId);
	}

	/**
	 * loggedUserProfileId rejects frend request from frendProfileId .
	 *
	 * @param loggedUserProfileId the Id
	 * @param frendProfileId      the Id
	 */
	@Transactional
	public void rejectFriendRequest(final Long loggedUserProfileId, final Long frendProfileId)
	{
		friendDao.rejectFriendRequest(loggedUserProfileId, frendProfileId);
	}

	/**
	 * Sets new friendDao.
	 *
	 * @param friendDao New value of friendDao.
	 */
	public void setFriendDao(final FriendDao friendDao)
	{
		this.friendDao = friendDao;
	}
}