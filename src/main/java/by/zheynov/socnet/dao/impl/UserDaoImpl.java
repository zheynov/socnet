package by.zheynov.socnet.dao.impl;

import by.zheynov.socnet.dao.UserDao;
import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.entity.UserEntity;
import by.zheynov.socnet.service.PasswordEncoding;

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

	public boolean isLoginExists(String login)
	{

		String userHQL = "FROM UserEntity WHERE login = :login";
		org.hibernate.query.Query query = getCurrentSession().createQuery(userHQL);
		query.setParameter("login", login);
		return query.list().size() > 0;
	}

	public boolean isUserPasswpodlCorrect(UserDTO user)
	{

		String login = user.getLogin();
		String password = PasswordEncoding.encodePassword(user.getPassword());

		String userHQL = "FROM UserEntity WHERE password=:password AND login=:login";
		Query query = getCurrentSession().createQuery(userHQL);
		query.setParameter("password", password);
		query.setParameter("login", login);

		List userEntities = query.list();

		return userEntities.size() > 0;
	}

	public boolean isEmailExists(String email)
	{

		String userHQL = "FROM UserEntity WHERE email = :email";
		Query query = getCurrentSession().createQuery(userHQL);
		query.setParameter("email", email);

		List userEntities = query.list();

		return userEntities.size() > 0;
	}
}
