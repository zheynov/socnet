package by.zheynov.socnet.facade.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import by.zheynov.socnet.dto.ProfileDTO;

import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.facade.ProfileFacade;
import by.zheynov.socnet.service.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

/**
 * Profile facade implementation.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.facade
 */
@Component("profileFacade")
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
		profileService.createProfile(conversionService.convert(profileDTO, ProfileEntity.class));
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
		return conversionService.convert(profileService.getProfileById(profileId), ProfileDTO.class);
	}

	/**
	 * Uptades user's profile in database.
	 *
	 * @param profileDTO the dto
	 */
	public void updateProfile(final ProfileDTO profileDTO)
	{
		profileService.updateProfile(conversionService.convert(profileDTO, ProfileEntity.class));
	}

	/**
	 * Deletes user's profile from database.
	 *
	 * @param profileDTO the dto
	 */
	public void deleteProfile(final ProfileDTO profileDTO)
	{
		profileService.deleteProfile(conversionService.convert(profileDTO, ProfileEntity.class));
	}

	/**
	 * Gets a list of profiles.
	 *
	 * @return List<ProfileDTO>
	 */
	public List<ProfileDTO> getAllTheProfiles()
	{
		List<ProfileDTO> allTheDTOProfiles = new ArrayList<>();

		profileService.getAllTheProfiles().
						forEach(element -> allTheDTOProfiles.add(conversionService.convert(element, ProfileDTO.class)));

		return allTheDTOProfiles;
	}

	/**
	 * Retrieves a set of ProfileDTO objects.
	 *
	 * @param currentLoggedUserProfileId the Id
	 *
	 * @return list of dto's
	 */
	public Set<ProfileDTO> getAllTheProfilesOfFriends(final Long currentLoggedUserProfileId)
	{
		Set<ProfileDTO> allTheProfilesDTO = new HashSet<>();

		profileService.getAllTheProfilesOfFriends(currentLoggedUserProfileId).
						forEach(element -> allTheProfilesDTO.add(conversionService.convert(element, ProfileDTO.class)));

		return allTheProfilesDTO;
	}

	/**
	 * Retrieves a list of ProfileDTO objects for non-pending friends.
	 *
	 * @param currentLoggedUserProfileId the Id
	 * @param currentLoggedUsername      the username
	 *
	 * @return list of dto's
	 */
	public Set<ProfileDTO> getAllTheProfilesOfNonPendingAndNotFriends(final Long currentLoggedUserProfileId,
	                                                                  final String currentLoggedUsername)
	{
		Set<ProfileDTO> allTheProfilesDTO = new HashSet<>();

		profileService.getAllTheProfilesOfNonPendingAndNotFriends(currentLoggedUserProfileId, currentLoggedUsername).
						forEach(element -> allTheProfilesDTO.add(conversionService.convert(element, ProfileDTO.class)));

		return allTheProfilesDTO;
	}

	/**
	 * Retrieves a list of profileEntity objects using reqiest.
	 *
	 * @param request the request
	 *
	 * @return the List<ProfileDTO>
	 */
	@Override
	public List<ProfileDTO> getAllTheProfilesOneParameter(final String request)
	{
		List<ProfileDTO> allTheProfilesDTO = new ArrayList<>();
		profileService.getAllTheProfilesOneParameter(request)
		              .forEach(element -> allTheProfilesDTO.add(conversionService.convert(element, ProfileDTO.class)));
		return allTheProfilesDTO;
	}
}
