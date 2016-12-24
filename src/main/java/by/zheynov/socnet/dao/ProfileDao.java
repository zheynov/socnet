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
	ProfileEntity getById(Long profileId);

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
	 * Retrieves a list of profileEntity objects using 2 parameters.
	 *
	 * @param firstname the firstname
	 * @param lastname  the lastname
	 *
	 * @return the List<profileEntity>
	 */
	List<ProfileEntity> getAllTheProfilesTwoParametres(String firstname, String lastname);

	/**
	 * Retrieves a list of profileEntity objects using 1 parameter.
	 *
	 * @param parametr the parametr
	 *
	 * @return the List<profileEntity>
	 */
	List<ProfileEntity> getAllTheProfilesOneParameter(String parametr);

}
