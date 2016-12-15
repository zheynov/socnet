package by.zheynov.socnet.service.impl;

import by.zheynov.socnet.dao.FriendDao;
import by.zheynov.socnet.dao.ProfileDao;
import by.zheynov.socnet.entity.FriendRequestApprovalStatus;
import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.service.ProfileService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Profile service implementation.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.service.impl
 */

@Service("profileService")
public class ProfileServiceImpl implements ProfileService
{
	private final static Logger LOGGER = Logger.getLogger(ProfileServiceImpl.class);
	@Autowired
	private ProfileDao    profileDao;
	@Autowired
	private FriendDao     friendDao;
	@Autowired
	private MessageSource messageSource;

	/**
	 * Saves profile entity to database.
	 *
	 * @param profileEntity the entity
	 */
	@Transactional
	public void createProfile(final ProfileEntity profileEntity)
	{
		profileDao.createProfile(profileEntity);
		LOGGER.info(messageSource.getMessage("service.profile.save", new Object[] {profileEntity}, Locale.ENGLISH));
	}

	/**
	 * Gets profile from database by its id.
	 *
	 * @param profileId the id
	 *
	 * @return the entity
	 */
	@Transactional(readOnly = true)
	public ProfileEntity getProfileById(final Long profileId)
	{
		LOGGER.info(messageSource.getMessage("service.profile.getById", new Object[] {profileId}, Locale.ENGLISH));
		return profileDao.getById(profileId);
	}

	/**
	 * Uptades user's profile in database.
	 *
	 * @param profileEntity the entity
	 */
	@Transactional
	public void updateProfile(final ProfileEntity profileEntity)
	{
		LOGGER.info(messageSource.getMessage("service.profile.update", new Object[] {profileEntity}, Locale.ENGLISH));
		profileDao.updateProfile(profileEntity);
	}

	/**
	 * Deletes user's profile from database.
	 *
	 * @param profileEntity the entity
	 */
	@Transactional
	public void deleteProfile(final ProfileEntity profileEntity)
	{
		LOGGER.info(messageSource.getMessage("service.profile.delete", new Object[] {profileEntity}, Locale.ENGLISH));
		profileDao.deleteProfile(profileEntity);

	}

	/**
	 * Retrieves a list of ProfileEntity objects.
	 *
	 * @return the List<ProfileEntity>
	 */
	@Transactional(readOnly = true)
	public List<ProfileEntity> getAllTheProfiles()
	{
		List<ProfileEntity> allTheProfiles = profileDao.getAllTheProfiles();
		allTheProfiles.removeIf(elem -> elem.getUserEntity().getUsername().equals("admin"));
		return allTheProfiles;
	}

	/**
	 * Retrieves a list of ProfileEntity objects.
	 *
	 * @param currentLoggedUserProfileId the Id
	 *
	 * @return list of entities
	 */
	@Transactional(readOnly = true)
	public List<ProfileEntity> getAllTheProfilesOfFriends(final Long currentLoggedUserProfileId)
	{
		List<ProfileEntity> allTheFriendProfiles = new ArrayList<>();

		friendDao.getAllTheFriends(currentLoggedUserProfileId).stream().
						filter(elem -> elem.getStatus() == FriendRequestApprovalStatus.APPROVED_REQUEST).
						         forEach(elem -> allTheFriendProfiles.add(profileDao.getById(elem.getFriendProfileEntity().getId())));

		return allTheFriendProfiles;
	}

	/**
	 * Retrieves a list of ProfileEntity objects for non-pending users.
	 * These users are not a friends as well.
	 *
	 * @param currentLoggedUserProfileId the Id
	 * @param currentLoggedUsername      the username
	 *
	 * @return list of entities
	 */
	@Transactional(readOnly = true)
	public List<ProfileEntity> getAllTheProfilesOfNonPendingAndNotFriends(final Long currentLoggedUserProfileId,
	                                                                      final String currentLoggedUsername)
	{
		List<ProfileEntity> allTheFriendProfiles = new ArrayList<>(); // result of our method
		List<ProfileEntity> allTheProfiles = getAllTheProfiles(); //all the profiles of our site
		List<ProfileEntity> allTheProfilesOfFriends
						= getAllTheProfilesOfFriends(currentLoggedUserProfileId); //all the profiles of currentLoggedUser

		// adds user to allTheFriendProfiles if a user is not a friend
		allTheProfiles.stream().filter(elem -> !allTheProfilesOfFriends.contains(elem)).forEach(allTheFriendProfiles::add);

		// remoes user from allTheFriendProfiles if user is currentLoggedUser or admin
		allTheProfiles.stream().
						filter(elem -> elem.getUserEntity().getUsername().equalsIgnoreCase(currentLoggedUsername) ||
										elem.getUserEntity().getUsername().equalsIgnoreCase("admin")).
						              forEach(allTheFriendProfiles::remove);

		// for removing pending users wich are still not a friends of user
		friendDao.getAllTheFriends(currentLoggedUserProfileId).stream().
						filter(elem -> elem.getStatus() == FriendRequestApprovalStatus.PENDING_REQUEST).
						         filter(elem -> allTheFriendProfiles.contains(profileDao.getById(elem.getFriendProfileEntity().getId()))).
						         forEach(elem -> allTheFriendProfiles.remove(profileDao.getById(elem.getFriendProfileEntity().getId())));

		return allTheFriendProfiles;
	}

	/**
	 * Retrieves a list of profileEntity objects using reqiest.
	 *
	 * @param request the request
	 *
	 * @return the List<ProfileEntity>
	 */
	@Override
	public List<ProfileEntity> getAllTheProfilesOneParameter(final String request)
	{
		String[] params = request.trim().split(" ");

		List<ProfileEntity> result = new ArrayList<>();

		if (params.length == 1)
		{
			result = profileDao.getAllTheProfilesOneParameter(params[0]);
		}
		else if (params.length == 2)
		{
			result = profileDao.getAllTheProfilesTwoParametres(params[0], params[1]);
		}

		//LOGGER.info("Saved photo for profileID " + photoEntity.getProfileEntity());
		return result;
	}
}
