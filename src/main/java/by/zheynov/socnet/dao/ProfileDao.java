package by.zheynov.socnet.dao;

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
	 * @param profile the entity
	 *
	 * @return the entity
	 */
	ProfileEntity createProfile(ProfileEntity profile);

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
	 * @param profile the entity
	 */
	void updateProfile(ProfileEntity profile);

	/**
	 * Deletes.
	 *
	 * @param profile the entity
	 */
	void deleteProfile(ProfileEntity profile);

}
