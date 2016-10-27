package by.zheynov.socnet.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Redlaw on 24.10.2016.
 */


@Transactional
public abstract class AbstractBaseDAO {

    private SessionFactory sessionFactory;

    public void save(Object object) {
        sessionFactory.getCurrentSession().save(object);
    }

    public void getById() {
    }

    public void udate(Object object) {
    }

    public void delete(Object object) {
    }

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

}