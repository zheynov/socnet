package by.zheynov.socnet.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
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

	void save(Object object)
	{
		sessionFactory.getCurrentSession().save(object);
	}

	public void getById()
	{
	}

	void udate(Object object)
	{
		sessionFactory.getCurrentSession().update(object);
	}

	void delete(Object object)
	{
		sessionFactory.getCurrentSession().delete(object);
	}

	Session getCurrentSession()
	{
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

}