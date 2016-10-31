package by.zheynov.socnet.service;

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
