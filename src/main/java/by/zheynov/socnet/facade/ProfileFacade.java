package by.zheynov.socnet.facade;

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
}
