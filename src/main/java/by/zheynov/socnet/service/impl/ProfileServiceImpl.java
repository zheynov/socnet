package by.zheynov.socnet.service.impl;

import by.zheynov.socnet.dao.ProfileDao;
import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.service.ProfileService;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

/**
 * ProfileServiceImpl.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao.impl
 */

public class ProfileServiceImpl implements ProfileService
{
	private final static Logger LOGGER = Logger.getLogger(ProfileServiceImpl.class);
	private ProfileDao    profileDao;
	private MessageSource messageSource;

	@Transactional
	public void createProfile(final ProfileEntity profileEntity)
	{
		profileDao.createProfile(profileEntity);
		LOGGER.info(messageSource.getMessage("service.profile.save", new Object[] {profileEntity}, Locale.ENGLISH));
	}

	@Transactional
	public ProfileEntity getProfileById(final Long profileId)
	{
		LOGGER.info(messageSource.getMessage("service.profile.getById", new Object[] {profileId}, Locale.ENGLISH));
		return profileDao.getProfileById(profileId);
	}

	@Transactional
	public void updateProfile(final ProfileEntity profileEntity)
	{
		LOGGER.info(messageSource.getMessage("service.profile.update", new Object[] {profileEntity}, Locale.ENGLISH));
		profileDao.updateProfile(profileEntity);
	}

	@Transactional
	public void deleteProfile(final ProfileEntity profileEntity)
	{
		LOGGER.info(messageSource.getMessage("service.profile.delete", new Object[] {profileEntity}, Locale.ENGLISH));

	}

	public void setProfileDao(ProfileDao profileDao)
	{
		this.profileDao = profileDao;
	}

	public void setMessageSource(MessageSource messageSource)
	{
		this.messageSource = messageSource;
	}
}
