package by.zheynov.socnet.dao.impl;

import by.zheynov.socnet.dao.UserDao;
import by.zheynov.socnet.entity.UserEntity;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.query.Query;
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
	private static final String GET_USER_BY_USERNAME_QUERY      = "FROM UserEntity WHERE username = :username";
	private static final String GET_EMAILADDRESS_BY_EMAIL_QUERY = "FROM UserEntity WHERE email = :email";

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
		if (objects.size()>0) {
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
		final List allTheUsers = criteria.list();
		return allTheUsers;
	}

	/**
	 * Ckecks if user with such username already exists in database.
	 *
	 * @param username the username
	 *
	 * @return true if login is exits, otherwise false
	 */
	public boolean isLoginExists(final String username)
	{
		org.hibernate.query.Query query = getCurrentSession().createQuery(GET_USER_BY_USERNAME_QUERY);
		query.setParameter("username", username);
		return query.list().size() > 0;
	}

	/**
	 * Ckecks if user with such email already exists in database.
	 *
	 * @param email the email
	 *
	 * @return true if email is exits, otherwise false
	 */
	public boolean isEmailExists(final String email)
	{
		Query query = getCurrentSession().createQuery(GET_EMAILADDRESS_BY_EMAIL_QUERY);
		query.setParameter("email", email);

		List userEntities = query.list();

		return userEntities.size() > 0;
	}
}
