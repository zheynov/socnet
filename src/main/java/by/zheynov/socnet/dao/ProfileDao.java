package by.zheynov.socnet.dao;

import by.zheynov.socnet.entity.ProfileEntity;

/**
 * Created by vazh on 19.10.2016.
 */

public interface ProfileDao {

    ProfileEntity createProfile(ProfileEntity profile);

    ProfileEntity getProfileById(Long profileId);

    void updateProfile(ProfileEntity profile);

    void deleteProfile(ProfileEntity profile);

}
