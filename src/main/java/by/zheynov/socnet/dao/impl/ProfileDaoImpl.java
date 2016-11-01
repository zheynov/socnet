package by.zheynov.socnet.dao.impl;

import by.zheynov.socnet.dao.ProfileDao;
import by.zheynov.socnet.entity.ProfileEntity;

import org.hibernate.Session;

/**
 * ProfileEntity DAO Implementation.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao.impl
 */

public class ProfileDaoImpl extends AbstractBaseDAO implements ProfileDao
{
	/**
	 * Saves profile entity to database.
	 *
	 * @param profile the entity
	 *
	 * @return profile entity
	 */
	public ProfileEntity createProfile(final ProfileEntity profile)
	{
		save(profile);
		return profile;
	}

	/**
	 * Gets ProfileEntity from database.
	 *
	 * @param profileId the id
	 *
	 * @return profile entity
	 */
	public ProfileEntity getProfileById(final Long profileId)
	{
		Session session = getCurrentSession();
		return null;
	}

	/**
	 * Uptades user's profile in database.
	 *
	 * @param profile the entity
	 */
	public void updateProfile(final ProfileEntity profile)
	{
		udate(profile);
	}

	/**
	 * Deletes user's profile from database.
	 *
	 * @param profile the entity
	 */
	public void deleteProfile(final ProfileEntity profile)
	{
		delete(profile);
	}

}
