package by.zheynov.socnet.dao.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import by.zheynov.socnet.dao.ProfileDao;
import by.zheynov.socnet.entity.ProfileEntity;

import org.hibernate.Criteria;

/**
 * ProfileEntity DAO Implementation.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao.impl
 */

public class ProfileDaoImpl extends AbstractBaseDAO implements ProfileDao
{
	/**
	 * Saves profile entity to database.
	 *
	 * @param profile the entity
	 *
	 * @return profile entity
	 */
	public ProfileEntity createProfile(final ProfileEntity profile)
	{
		save(profile);
		return profile;
	}

	/**
	 * Gets ProfileEntity from database.
	 *
	 * @param profileId the id
	 *
	 * @return profile entity
	 */
	public ProfileEntity getProfileById(final Long profileId)
	{
		return getCurrentSession().get(ProfileEntity.class, profileId);
	}

	/**
	 * Uptades user's profile in database.
	 *
	 * @param profile the entity
	 */
	public void updateProfile(final ProfileEntity profile)
	{
		udate(profile);
	}

	/**
	 * Deletes user's profile from database.
	 *
	 * @param profile the entity
	 */
	public void deleteProfile(final ProfileEntity profile)
	{
		delete(profile);
	}

	/**
	 * Gets a list of user's profiles.
	 *
	 * @return List<ProfileEntity>
	 */
	public List<ProfileEntity> getAllTheProfiles()
	{
		final Criteria criteria = getCurrentSession().createCriteria(ProfileEntity.class);
		final List allTheUsers = criteria.list();
		return allTheUsers;
	}

	/**
	 * Adds new friend to user's friends set using their profiles.
	 *
	 * @param currentProfile  the entity
	 * @param friendProfileId the Id
	 */

	public void addFriend(final ProfileEntity currentProfile, final Long friendProfileId)
	{
		ProfileEntity newFriendProfile = new ProfileEntity();
		newFriendProfile.setId(friendProfileId);

		Set<ProfileEntity> friends = currentProfile.getUserFriends();
		friends.add(newFriendProfile);

		currentProfile.setUserFriends(friends);

		save(friendProfileId);
	}
}
