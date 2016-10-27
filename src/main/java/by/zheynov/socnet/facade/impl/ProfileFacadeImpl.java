package by.zheynov.socnet.facade.impl;

import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.facade.ProfileFacade;
import by.zheynov.socnet.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;

/**
 * Created by vazh on 21.10.2016.
 */

public class ProfileFacadeImpl implements ProfileFacade {

    @Autowired
    private ProfileService profileService;
    @Autowired
    private ConversionService conversionService;


    public void createProfile(ProfileDTO profileDTO) {

    }

    public ProfileEntity getProfileById(Long profile_id) {
        return null;
    }

    public void updateProfile(ProfileDTO profileDTO) {

    }

    public void deleteProfile(ProfileDTO profileDTO) {

    }
}
