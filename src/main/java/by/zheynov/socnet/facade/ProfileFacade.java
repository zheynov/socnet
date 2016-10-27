package by.zheynov.socnet.facade;

import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.entity.ProfileEntity;

/**
 * Created by vazh on 21.10.2016.
 */
public interface ProfileFacade {
    
    void createProfile(ProfileDTO profileDTO);

    ProfileEntity getProfileById(Long profile_id);

    void updateProfile(ProfileDTO profileDTO);

    void deleteProfile(ProfileDTO profileDTO);
}
