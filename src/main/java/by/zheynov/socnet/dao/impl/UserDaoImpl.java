package by.zheynov.socnet.dao.impl;

import by.zheynov.socnet.dao.UserDao;
import by.zheynov.socnet.entity.UserEntity;

import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * User Dao Implementation.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao.impl
 */

@Transactional
@Repository("userDao")
public class UserDaoImpl extends AbstractBaseDAO implements UserDao
{
	private static final String GET_USER_BY_USERNAME_QUERY          = "FROM UserEntity WHERE username = :username";
	private static final String GET_USER_BY_USERNAME_OR_EMAIL_QUERY = "FROM UserEntity WHERE username = :username OR email = " +
					":email";
	private static final String GET_ALL_USERS_QUERY                 = "SELECT * FROM user";

	/**
	 * Creates user in database.
	 *
	 * @param user the entity
	 *
	 * @return the entity
	 */
	public UserEntity createUser(final UserEntity user)
	{
		super.save(user);
		return user;
	}

	/**
	 * Updates the user in database.
	 *
	 * @param user the entity
	 *
	 * @return the entity
	 */
	public UserEntity updateUser(final UserEntity user)
	{
		super.udate(user);
		return user;
	}

	/**
	 * Deletes usre form database.
	 *
	 * @param user the entity
	 */
	public void deleteUser(final UserEntity user)
	{
		super.delete(user);
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
		Query query = super.getCurrentSession().createQuery(GET_USER_BY_USERNAME_QUERY);
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
		Query query = super.getCurrentSession().createNativeQuery(GET_ALL_USERS_QUERY, UserEntity.class);
		return query.list();
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
		Query query = super.getCurrentSession().createQuery(GET_USER_BY_USERNAME_OR_EMAIL_QUERY);
		query.setParameter("username", username);
		query.setParameter("email", email);

		return query.list();
	}

	/**
	 * Gets UserEntity from database.
	 *
	 * @param userId the id
	 *
	 * @return user entity
	 */
	public UserEntity getById(final Long userId)
	{
		return (UserEntity) super.getById(UserEntity.class, userId);
	}
}
