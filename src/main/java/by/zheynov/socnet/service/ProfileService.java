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
	 * Retrieves a list of Friends ProfileEntity objects.
	 *
	 * @param currentLoggedUserProfileId the Id
	 *
	 * @return list of entities
	 */
	List<ProfileEntity> getAllTheProfilesOfFriends(Long currentLoggedUserProfileId);

	/**
	 * Retrieves a list of ProfileEntity objects for non-pending users.
	 * These users are not a friends as well.
	 *
	 * @param currentLoggedUserProfileId the Id
	 * @param currentLoggedUsername      the username
	 *
	 * @return list of entities
	 */
	List<ProfileEntity> getAllTheProfilesOfNonPendingAndNotFriends(final Long currentLoggedUserProfileId,
	                                                               final String currentLoggedUsername);

}
