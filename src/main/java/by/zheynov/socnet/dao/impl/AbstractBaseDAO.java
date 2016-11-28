package by.zheynov.socnet.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import by.zheynov.socnet.entity.FriendEntity;

/**
 * AbstractBaseDAO.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao.impl
 */

@Transactional
public abstract class AbstractBaseDAO
{
	private SessionFactory sessionFactory;

	/**
	 * Saves the object to data base.
	 *
	 * @param object the object
	 */
	void save(final Object object)
	{
		sessionFactory.getCurrentSession().save(object);
	}

	/**
	 * Updates the object in data base.
	 *
	 * @param object the object
	 */
	void udate(final Object object)
	{
		sessionFactory.getCurrentSession().update(object);
	}

	/**
	 * Deletes the object from data base.
	 *
	 * @param object the object
	 */
	void delete(final Object object)
	{
		sessionFactory.getCurrentSession().delete(object);
	}

	/**
	 * Obtains current session.
	 *
	 * @return the current session.
	 */
	Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}

	/**
	 * Sets new sessionFactory.
	 *
	 * @param sessionFactory New value of sessionFactory.
	 */
	public void setSessionFactory(final SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	/**
	 * Gets the object from data base by its id.
	 *
	 * @param id the id
	 *
	 * @return the object.
	 */
	public Object getById(final Class<?> clazz, final Long id)
	{
		return getCurrentSession().get(clazz, id);
	}
}