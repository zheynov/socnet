package by.zheynov.socnet.service;

import java.util.List;

import by.zheynov.socnet.entity.ProfileEntity;

/**
 * Profile service interface.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.service
 */
public interface ProfileService
{

	/**
	 * Saves.
	 *
	 * @param profileEntity the entity
	 */
	void createProfile(ProfileEntity profileEntity);

	/**
	 * Finds By profileId.
	 *
	 * @param profileId the id
	 *
	 * @return the ProfileEntity
	 */
	ProfileEntity getProfileById(Long profileId);

	/**
	 * Updates.
	 *
	 * @param profileEntity the entity
	 */
	void updateProfile(ProfileEntity profileEntity);

	/**
	 * Deletes.
	 *
	 * @param profileEntity the entity
	 */
	void deleteProfile(ProfileEntity profileEntity);

	/**
	 * Retrieves a list of ProfileEntity objects.
	 *
	 * @return the List<ProfileEntity>
	 */
	List<ProfileEntity> getAllTheProfiles();

	/**
	 * Adds new friend to user's friends set using their profiles.
	 *
	 * @param currentProfile  the entity
	 * @param friendProfileId the Id
	 */

	void addFriend(final ProfileEntity currentProfile, final Long friendProfileId);

}
