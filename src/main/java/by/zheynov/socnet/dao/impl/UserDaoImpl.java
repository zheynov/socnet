package by.zheynov.socnet.dao.impl;

import by.zheynov.socnet.dao.UserDao;
import by.zheynov.socnet.entity.UserEntity;

import org.hibernate.Criteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User Dao Implementation.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao.impl
 */

@Transactional
public class UserDaoImpl extends AbstractBaseDAO implements UserDao
{
	private static final String GET_USER_BY_USERNAME_QUERY          = "FROM UserEntity WHERE username = :username";
	private static final String GET_USER_BY_USERNAME_OR_EMAIL_QUERY = "FROM UserEntity WHERE username = :username OR email = " +
					":email";


	/**
	 * Creates user in database.
	 *
	 * @param user the entity
	 *
	 * @return the entity
	 */
	public UserEntity createUser(final UserEntity user)
	{
		save(user);
		return user;
	}

	/**
	 * Updates the user in database.
	 *
	 * @param user the entity
	 */
	public void updateUser(final UserEntity user)
	{
		udate(user);
	}

	/**
	 * Deletes usre form database.
	 *
	 * @param user the entity
	 */
	public void deleteUser(final UserEntity user)
	{
		delete(user);
	}

	/**
	 * Gets user from database by its username.
	 *
	 * @param username the username
	 *
	 * @return the entity
	 */
	public UserEntity getUserByUsername(final String username)
	{
		org.hibernate.query.Query query = getCurrentSession().createQuery(GET_USER_BY_USERNAME_QUERY);
		query.setParameter("username", username);

		List objects = query.list();
		if (objects.size() > 0)
		{
			return (UserEntity) objects.get(0);
		}
		return null;
	}

	/**
	 * Gets a list of users.
	 *
	 * @return List<UserEntity>
	 */
	public List<UserEntity> getAllTheUsers()
	{
		final Criteria criteria = getCurrentSession().createCriteria(UserEntity.class);
		return criteria.list();
	}

	/**
	 * Returns a list of users with such email or username.
	 *
	 * @param username the username
	 * @param email    the email
	 *
	 * @return list of users
	 */
	public List<UserEntity> getUserByUsernameOrEmail(final String username, final String email)
	{
		org.hibernate.query.Query query = getCurrentSession().createQuery(GET_USER_BY_USERNAME_OR_EMAIL_QUERY);
		query.setParameter("username", username);
		query.setParameter("email", email);

		return query.list();
	}

}
