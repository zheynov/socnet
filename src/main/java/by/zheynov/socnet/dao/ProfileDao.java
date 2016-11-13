package by.zheynov.socnet.dao;

import java.util.List;

import by.zheynov.socnet.entity.ProfileEntity;

/**
 * Profile Dao interface.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao
 */

public interface ProfileDao
{
	/**
	 * Saves.
	 *
	 * @param profileEntity the entity
	 *
	 * @return the entity
	 */
	ProfileEntity createProfile(ProfileEntity profileEntity);

	/**
	 * Finds By profileId.
	 *
	 * @param profileId the id
	 *
	 * @return the entity
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
	 * Retrieves a list of profileEntity objects.
	 *
	 * @return the List<profileEntity>
	 */
	List<ProfileEntity> getAllTheProfiles();

	/**
	 * Adds new friend to user's friends set using their profiles.
	 *
	 * @param currentProfile the entity
	 * @param newFriend      the entity
	 */


}
