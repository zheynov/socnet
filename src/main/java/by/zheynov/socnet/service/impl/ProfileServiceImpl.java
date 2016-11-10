package by.zheynov.socnet.service.impl;

import by.zheynov.socnet.dao.ProfileDao;
import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.service.ProfileService;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.transaction.annotation.Transactional;

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
		return profileDao.getProfileById(profileId);
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
	public List<ProfileEntity> getAllTheProfiles()
	{
		return profileDao.getAllTheProfiles();
	}

	/**
	 * Adds new friend to user's friends set using their profiles.
	 *
	 * @param currentProfile  the entity
	 * @param friendProfileId the Id
	 */

	public void addFriend(final ProfileEntity currentProfile, final Long friendProfileId)
	{
		profileDao.addFriend(currentProfile, friendProfileId);
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

}
