package by.zheynov.socnet.dao.impl;

import by.zheynov.socnet.dao.UserDao;
import by.zheynov.socnet.dto.UserDTO;
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

	public UserEntity createUser(final UserEntity user)
	{
		save(user);
		return user;
	}

	public void updateUser(final UserEntity user)
	{
		udate(user);
	}

	public void deleteUser(final UserEntity user)
	{
		delete(user);
	}

	public UserEntity getUserByLogin(String login)
	{
		Session session = getCurrentSession();
		return null;
	}

	public List<UserEntity> getAllTheUsers()
	{

		final Criteria criteria = getCurrentSession().createCriteria(UserEntity.class);
		final List allTheUsers = criteria.list();
		return allTheUsers;
	}

	public boolean isLoginExists(String username)
	{
		org.hibernate.query.Query query = getCurrentSession().createQuery(GET_USER_BY_USERNAME_QUERY);
		query.setParameter("username", username);
		return query.list().size() > 0;
	}

	public boolean isEmailExists(String email)
	{
		Query query = getCurrentSession().createQuery(GET_EMAILADDRESS_BY_EMAIL_QUERY);
		query.setParameter("email", email);

		List userEntities = query.list();

		return userEntities.size() > 0;
	}

}
