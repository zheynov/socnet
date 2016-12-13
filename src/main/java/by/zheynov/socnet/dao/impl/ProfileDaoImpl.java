package by.zheynov.socnet.dao.impl;

import java.util.List;

import by.zheynov.socnet.dao.ProfileDao;

import by.zheynov.socnet.entity.ProfileEntity;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * ProfileEntity DAO Implementation.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao.impl
 */
@Repository("profileDao")
@Transactional
public class ProfileDaoImpl extends AbstractBaseDAO implements ProfileDao
{
	private static final String GET_ALL_USER_PROFILES_QUERY = "SELECT * FROM profile";

	private static final String GET_ALL_USER_PROFILES_QUERY_TWO_PARAMETERS =
					"FROM ProfileEntity WHERE firstname LIKE :firstname OR " + "lastname LIKE :lastname";
	private static final String GET_ALL_USER_PROFILES_QUERY_ONE_PARAMETER  =
					"FROM ProfileEntity WHERE firstname LIKE :parametr OR " + "lastname LIKE :parametr";

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
		return (ProfileEntity) super.getById(ProfileEntity.class, profileId);
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

	/**
	 * Retrieves a list of profileEntity objects using 2 parameters.
	 *
	 * @param firstname the firstname
	 * @param lastname  the lastname
	 *
	 * @return the List<profileEntity>
	 */
	@Override
	public List<ProfileEntity> getAllTheProfilesTwoParametres(final String firstname, final String lastname)
	{
		Query query = super.getCurrentSession().createQuery(GET_ALL_USER_PROFILES_QUERY_TWO_PARAMETERS);
		query.setParameter("firstname", "%" + firstname + "%");
		query.setParameter("lastname", "%" + lastname + "%");
		return query.list();
	}

	/**
	 * Retrieves a list of profileEntity objects using 1 parameter.
	 *
	 * @param parametr the parametr
	 *
	 * @return the List<profileEntity>
	 */
	public List<ProfileEntity> getAllTheProfilesOneParameter(final String parametr)
	{
		Query query = super.getCurrentSession().createQuery(GET_ALL_USER_PROFILES_QUERY_ONE_PARAMETER);
		query.setParameter("parametr", "%" + parametr + "%");
		return query.list();
	}

}
