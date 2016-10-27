package by.zheynov.socnet.dao.impl;

import by.zheynov.socnet.dao.ProfileDao;
import by.zheynov.socnet.entity.ProfileEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by zheynovvv on 20.10.2016.
 */

public class ProfileDaoImpl extends AbstractBaseDAO implements ProfileDao {


    public ProfileEntity createProfile(final ProfileEntity profile) {
        save(profile);
        return profile;
    }

    public ProfileEntity getProfileById(final Long profileId) {
        Session session = getCurrentSession();
        return null;
    }

    public void updateProfile(final ProfileEntity profile) {
        udate(profile);
    }

    public void deleteProfile(final ProfileEntity profile) {
        delete(profile);
    }

}
