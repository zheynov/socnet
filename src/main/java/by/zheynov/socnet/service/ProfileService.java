package by.zheynov.socnet.service;

import by.zheynov.socnet.entity.ProfileEntity;

public interface ProfileService {

    void createProfile(ProfileEntity profileEntity);
    ProfileEntity getProfileById(Long profile_id);
    void updateProfile(ProfileEntity profile);
    void deleteProfile(ProfileEntity profile);
}
