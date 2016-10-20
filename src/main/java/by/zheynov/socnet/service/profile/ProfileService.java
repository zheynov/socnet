package by.zheynov.socnet.service.profile;

import by.zheynov.socnet.dao.profile.ProfileDao;
import by.zheynov.socnet.entity.ProfileEntity;

/**
 * Created by zheynovvv on 20.10.2016.
 */
public interface ProfileService {

    void createProfile(ProfileEntity profileEntity);
    ProfileEntity getProfileById(Long profile_id);
    void updateProfile(ProfileEntity profile);
    void deleteProfile(ProfileEntity profile);
}
