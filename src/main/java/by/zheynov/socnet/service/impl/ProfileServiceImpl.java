package by.zheynov.socnet.service.impl;

import by.zheynov.socnet.dao.FriendDao;
import by.zheynov.socnet.dao.ProfileDao;
import by.zheynov.socnet.entity.FriendEntity;
import by.zheynov.socnet.entity.FriendRequestApprovalStatus;
import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.service.ProfileService;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
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

public class ProfileServiceImpl implements ProfileService
{
	private final static Logger LOGGER = Logger.getLogger(ProfileServiceImpl.class);
	private ProfileDao    profileDao;
	private FriendDao     friendDao;
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
	@Transactional
	public ProfileEntity getProfileById(final Long profileId)
	{
		LOGGER.info(messageSource.getMessage("service.profile.getById", new Object[] {profileId}, Locale.ENGLISH));
		return (ProfileEntity) profileDao.getById(profileId);
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

	}

	/**
	 * Retrieves a list of ProfileEntity objects.
	 *
	 * @return the List<ProfileEntity>
	 */
	@Transactional
	public List<ProfileEntity> getAllTheProfiles()
	{
		return profileDao.getAllTheProfiles();
	}

	/**
	 * Retrieves a list of ProfileEntity objects.
	 *
	 * @param currentLoggedUserProfileId the Id
	 *
	 * @return list of entities
	 */
	@Transactional
	public List<ProfileEntity> getAllTheProfilesOfFriends(final Long currentLoggedUserProfileId)
	{
		List<ProfileEntity> allTheFriendProfiles = new ArrayList<ProfileEntity>();

		for (FriendEntity friendEntity : friendDao.getAllTheFriends(currentLoggedUserProfileId))
		{
			if (friendEntity.getStatus() == FriendRequestApprovalStatus.APPROVED_REQUEST)
			{
				final ProfileEntity profileEntity = (ProfileEntity) profileDao.getById(friendEntity.getFriendProfileEntity().getId());
				allTheFriendProfiles.add(profileEntity);
			}
		}
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
	@Transactional
	public List<ProfileEntity> getAllTheProfilesOfNonPendingAndNotFriends(final Long currentLoggedUserProfileId,
	                                                                      final String currentLoggedUsername)
	{
		List<ProfileEntity> allTheFriendProfiles = new ArrayList<ProfileEntity>();

		List<ProfileEntity> allTheProfiles = getAllTheProfiles();

		List<ProfileEntity> allTheProfilesOfFriends = getAllTheProfilesOfFriends(currentLoggedUserProfileId);

		for (ProfileEntity profileEntity : allTheProfiles)
		{
			if (!allTheProfilesOfFriends.contains(profileEntity))
			{
				allTheFriendProfiles.add(profileEntity);
			}

			if (profileEntity.getUserEntity().getUsername().equalsIgnoreCase(currentLoggedUsername) ||
							profileEntity.getUserEntity().getUsername().equalsIgnoreCase("admin"))
			{
				allTheFriendProfiles.remove(profileEntity);
			}
		}

		// for removing pending users wich are still not a friends of user
		for (FriendEntity friendEntity : friendDao.getAllTheFriends(currentLoggedUserProfileId))
		{
			if (friendEntity.getStatus() == FriendRequestApprovalStatus.PENDING_REQUEST)
			{
				final ProfileEntity profileEntity = (ProfileEntity) profileDao.getById(friendEntity.getFriendProfileEntity().getId());

				if (allTheFriendProfiles.contains(profileEntity))
				{
					allTheFriendProfiles.remove(profileEntity);
				}
							}
		}
		return allTheFriendProfiles;
	}

	/**
	 * Sets new messageSource.
	 *
	 * @param messageSource New value of messageSource.
	 */
	public void setMessageSource(final MessageSource messageSource)
	{
		this.messageSource = messageSource;
	}

	/**
	 * Sets new profileDao.
	 *
	 * @param profileDao New value of profileDao.
	 */

	public void setProfileDao(final ProfileDao profileDao)
	{
		this.profileDao = profileDao;
	}

	/**
	 * Sets new friendDao.
	 *
	 * @param friendDao New value of friendDao.
	 */
	public void setFriendDao(final FriendDao friendDao)
	{
		this.friendDao = friendDao;
	}
}
