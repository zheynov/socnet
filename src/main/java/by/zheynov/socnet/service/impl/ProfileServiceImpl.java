package by.zheynov.socnet.service.impl;

import by.zheynov.socnet.dao.ProfileDao;
import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.service.ProfileService;

import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

/**
 * Created by zheynovvv on 20.10.2016.
 */

public class ProfileServiceImpl implements ProfileService
{
	private final Logger LOGGER = Logger.getLogger(getClass());
	private ProfileDao    profileDao;
	private MessageSource messageSource;

	@Transactional
	public void createProfile(final ProfileEntity profileEntity)
	{
		profileDao.createProfile(profileEntity);
		LOGGER.info(messageSource.getMessage("service.profile.save", new Object[] {profileEntity}, Locale.ENGLISH));
	}

	@Transactional
	public ProfileEntity getProfileById(final Long profile_id)
	{
		return null;
	}

	@Transactional
	public void updateProfile(final ProfileEntity profile)
	{
	}

	@Transactional
	public void deleteProfile(final ProfileEntity profile)
	{
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
