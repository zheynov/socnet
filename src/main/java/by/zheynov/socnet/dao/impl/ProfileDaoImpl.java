package by.zheynov.socnet.dao.impl;

import java.util.List;

import by.zheynov.socnet.dao.ProfileDao;

import by.zheynov.socnet.entity.ProfileEntity;

import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * ProfileEntity DAO Implementation.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao.impl
 */
@Transactional
public class ProfileDaoImpl extends AbstractBaseDAO implements ProfileDao
{
	private static final String GET_ALL_USER_PROFILES_QUERY = "SELECT * FROM profile";

	/**
	 * Saves profile entity to database.
	 *
	 * @param profile the entity
	 *
	 * @return profile entity
	 */
	public ProfileEntity createProfile(final ProfileEntity profile)
	{
		super.save(profile);
		return profile;
	}

	/**
	 * Gets ProfileEntity from database.
	 *
	 * @param profileId the id
	 *
	 * @return profile entity
	 */
	public ProfileEntity getById(final Long profileId)
	{
		return super.getCurrentSession().get(ProfileEntity.class, profileId);
	}

	/**
	 * Uptades user's profile in database.
	 *
	 * @param profile the entity
	 */
	public void updateProfile(final ProfileEntity profile)
	{
		super.udate(profile);
	}

	/**
	 * Deletes user's profile from database.
	 *
	 * @param profile the entity
	 */
	public void deleteProfile(final ProfileEntity profile)
	{
		super.delete(profile);
	}

	/**
	 * Gets a list of user's profiles.
	 *
	 * @return List<ProfileEntity>
	 */
	public List<ProfileEntity> getAllTheProfiles()
	{
		Query query = super.getCurrentSession().createNativeQuery(GET_ALL_USER_PROFILES_QUERY, ProfileEntity.class);
		return query.list();
	}

}
