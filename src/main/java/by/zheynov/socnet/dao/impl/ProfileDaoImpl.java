package by.zheynov.socnet.dao.impl;

import by.zheynov.socnet.dao.ProfileDao;
import by.zheynov.socnet.entity.ProfileEntity;
import org.hibernate.SessionFactory;

/**
 * Created by zheynovvv on 20.10.2016.
 */

public class ProfileDaoImpl implements ProfileDao {

    private final SessionFactory sessionFactory;

    public ProfileDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public ProfileEntity createProfile(final ProfileEntity profile) {
        sessionFactory.getCurrentSession().save(profile);
        return profile;
    }

    public ProfileEntity getProfileById(final Long profileId) {
        return null;
    }

    public void updateProfile(final ProfileEntity profile) {
    }

    public void deleteProfile(final ProfileEntity profile) {
    }

}