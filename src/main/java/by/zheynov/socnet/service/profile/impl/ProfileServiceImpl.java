package by.zheynov.socnet.service.profile.impl;

import by.zheynov.socnet.dao.profile.ProfileDao;
import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.service.profile.ProfileService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zheynovvv on 20.10.2016.
 */

@Service("profileService")
public class ProfileServiceImpl implements ProfileService {

    private ProfileDao profileDao;

    public void setProfileDao(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    @Transactional
    public void createProfile(final ProfileEntity profileEntity) {
        profileDao.createProfile(profileEntity);
    }

    @Transactional
    public ProfileEntity getProfileById(final Long profile_id) {
        return null;
    }

    @Transactional
    public void updateProfile(final ProfileEntity profile) {

    }

    @Transactional
    public void deleteProfile(final ProfileEntity profile) {

    }
}
