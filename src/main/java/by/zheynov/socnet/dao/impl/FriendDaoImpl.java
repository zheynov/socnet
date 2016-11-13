package by.zheynov.socnet.dao.impl;

import java.util.List;
import java.util.Set;

import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import by.zheynov.socnet.dao.FriendDao;
import by.zheynov.socnet.entity.FriendEntity;
import by.zheynov.socnet.entity.FriendRequestApprovalStatus;
import by.zheynov.socnet.entity.ProfileEntity;

/**
 * FriendDaoImpl class.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao.impl
 */
@Transactional
public class FriendDaoImpl extends AbstractBaseDAO implements FriendDao
{
	private static final String DELETE_FRIEND_BY_FRIEND_ID
					= "DELETE FROM FriendEntity WHERE main_profile_id  = :loggedUserProfileId AND friends_profile_id = :frendProfileId";

	private static final String GET_ALL_THE_FRIENDS_QUERY = "FROM FriendEntity " + "WHERE main_profile_id = :profileId";

	private static final String GET_ALL_THE_FRIENDS_WITH_PENDING_STATUS_QUERY
					= "FROM FriendEntity WHERE friends_profile_id = :profileId";

	private static final String CHANGE_FRIEND_REQUEST_STATUS_QUERY = "UPDATE FriendEntity SET friend_request_status =:status " +
					"WHERE main_profile_id = :loggedUserProfileId AND  friends_profile_id = :frendProfileId";

	/**
	 * Adds new friend to user's friends set using their profiles.
	 *
	 * @param currentProfile the entity
	 * @param newFriend      the entity
	 */

	public void addFriend(final ProfileEntity currentProfile, final ProfileEntity newFriend)
	{
		FriendEntity friendEntity = new FriendEntity();
		friendEntity.setCurrentProfileEntity(currentProfile);
		friendEntity.setFriendProfileEntity(newFriend.getId());
		friendEntity.setStatus(FriendRequestApprovalStatus.PENDING_REQUEST);

		Set<FriendEntity> friends = currentProfile.getFriends();
		friends.add(friendEntity);

		currentProfile.setFriends(friends);
		udate(currentProfile);
		save(friendEntity);
	}

	/**
	 * Retrieves a list of FriendEntity objects for logged user with profileId.
	 *
	 * @param profileId the Id
	 *
	 * @return the List<friendEntity>
	 */
	public List<FriendEntity> getAllTheFriends(final Long profileId)
	{
		Query query = getCurrentSession().createQuery(GET_ALL_THE_FRIENDS_QUERY);
		query.setParameter("profileId", profileId);
		return query.list();
	}

	/**
	 * Retrieves a list of FriendEntity objects with status PENDING_REQUEST for user with profileId.
	 *
	 * @param profileId the Id
	 *
	 * @return the List<friendEntity>
	 */
	public List<FriendEntity> getAllThePendingRequests(final Long profileId)
	{
		Query query = getCurrentSession().createQuery(GET_ALL_THE_FRIENDS_WITH_PENDING_STATUS_QUERY);
		query.setParameter("profileId", profileId);
		return query.list();
	}

	/**
	 * Deletes a frend with friend's frendProfileId.
	 *
	 * @param loggedUserProfileId the Id
	 * @param frendProfileId      the Id
	 */
	public void deleteFriend(final Long loggedUserProfileId, final Long frendProfileId)
	{
		Query query = getCurrentSession().createQuery(DELETE_FRIEND_BY_FRIEND_ID);
		query.setParameter("loggedUserProfileId", loggedUserProfileId);
		query.setParameter("frendProfileId", frendProfileId);
		query.executeUpdate();
	}

	/**
	 * loggedUserProfileId approves frend request from frendProfileId .
	 *
	 * Current loggedUserProfileId = friends_profile_id in database
	 * frendProfileId  = main_profile_id in database
	 *
	 * @param loggedUserProfileId the Id
	 * @param frendProfileId      the Id
	 */
	public void approveFriendRequest(final Long loggedUserProfileId, final Long frendProfileId)
	{
		Query query = getCurrentSession().createQuery(CHANGE_FRIEND_REQUEST_STATUS_QUERY);

		query.setParameter("loggedUserProfileId", frendProfileId);
		query.setParameter("frendProfileId", loggedUserProfileId);
		query.setParameter("status", FriendRequestApprovalStatus.APPROVED_REQUEST.name());
		query.executeUpdate();

	}

	/**
	 * loggedUserProfileId rejects frend request from frendProfileId.
	 *
	 * Just delets a frendEntity from database
	 * Current loggedUserProfileId = friends_profile_id in database
	 * frendProfileId  = main_profile_id in database
	 *
	 * @param loggedUserProfileId the Id
	 * @param frendProfileId      the Id
	 */
	public void rejectFriendRequest(final Long loggedUserProfileId, final Long frendProfileId)
	{
		deleteFriend(frendProfileId, loggedUserProfileId);
	}
}