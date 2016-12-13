package by.zheynov.socnet.facade;

import java.util.List;
import java.util.Set;

import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.entity.ProfileEntity;

/**
 * Profile facade interface.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.facade
 */

public interface ProfileFacade
{

	/**
	 * Saves.
	 *
	 * @param profileDTO the dto
	 */
	void createProfile(ProfileDTO profileDTO);

	/**
	 * Finds By profileId.
	 *
	 * @param profileId the id
	 *
	 * @return the dto
	 */
	ProfileDTO getProfileById(Long profileId);

	/**
	 * Updates.
	 *
	 * @param profileDTO the dto
	 */
	void updateProfile(ProfileDTO profileDTO);

	/**
	 * Deletes.
	 *
	 * @param profileDTO the dto
	 */
	void deleteProfile(ProfileDTO profileDTO);

	/**
	 * Retrieves a list of ProfileDTO objects.
	 *
	 * @return the List<ProfileDTO>
	 */
	List<ProfileDTO> getAllTheProfiles();

	/**
	 * Retrieves a set of ProfileDTO objects.
	 *
	 * @param currentLoggedUserProfileId the Id
	 *
	 * @return list of dto's
	 */
	Set<ProfileDTO> getAllTheProfilesOfFriends(Long currentLoggedUserProfileId);

	/**
	 * Retrieves a set of ProfileDTO objects for non-pending friends.
	 *
	 * @param currentLoggedUserProfileId the Id
	 * @param currentLoggedUsername      the username
	 *
	 * @return list of dto's
	 */
	Set<ProfileDTO> getAllTheProfilesOfNonPendingAndNotFriends(Long currentLoggedUserProfileId, String currentLoggedUsername);

	/**
	 * Retrieves a list of profileEntity objects using reqiest.
	 *
	 * @param reqiest the reqiest
	 *
	 * @return the List<ProfileDTO>
	 */
	List<ProfileDTO> getAllTheProfilesOneParameter(String reqiest);

}
