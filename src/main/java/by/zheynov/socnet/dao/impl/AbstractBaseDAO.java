package by.zheynov.socnet.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

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
	 * Gets the object from data base by its id.
	 *
	 * @param id the id
	 */
	public abstract Object getById(final Long id);

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
}