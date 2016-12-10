package by.zheynov.socnet.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * AbstractBaseDAO.
 *
 * @author Vadim Zheynov <V.Zheynov@sam-solutions.com>
 * @package by.zheynov.socnet.dao.impl
 */

@Transactional
@Repository("abstractDao")
public abstract class AbstractBaseDAO
{
	@Autowired
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
	 * @param id    the id
	 * @param clazz the class
	 *
	 * @return the object.
	 */
	public Object getById(final Class<?> clazz, final Long id)
	{
		return getCurrentSession().get(clazz, id);
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
}