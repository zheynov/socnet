package by.zheynov.socnet.facade.impl;

import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.facade.ProfileFacade;
import by.zheynov.socnet.service.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

/**
 * Profile facade implementation.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.facade
 */

public class ProfileFacadeImpl implements ProfileFacade
{

	@Autowired
	private ProfileService    profileService;
	@Autowired
	private ConversionService conversionService;

	/**
	 * Saves profile dto to database.
	 *
	 * @param profileDTO the dto
	 */
	public void createProfile(final ProfileDTO profileDTO)
	{

	}

	/**
	 * Gets profile from database by its id.
	 *
	 * @param profileId the id
	 *
	 * @return the dto
	 */
	public ProfileDTO getProfileById(final Long profileId)
	{
		return null;
	}

	/**
	 * Uptades user's profile in database.
	 *
	 * @param profileDTO the dto
	 */
	public void updateProfile(final ProfileDTO profileDTO)
	{

	}

	/**
	 * Deletes user's profile from database.
	 *
	 * @param profileDTO the dto
	 */
	public void deleteProfile(final ProfileDTO profileDTO)
	{

	}
}
