package by.zheynov.socnet.converters;

import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.entity.ProfileEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by Redlaw on 27.10.2016.
 */

@Component
public class ProfileDTOReverseConverter implements Converter<ProfileDTO, ProfileEntity> {

    public ProfileEntity convert(ProfileDTO profileDTO) {

        if (profileDTO == null)
            return null;

        final ProfileEntity profileEntity = new ProfileEntity();

        profileEntity.setId(profileDTO.getProfileID());
        profileEntity.setFirstName(profileDTO.getFirstname());
        profileEntity.setLastname(profileDTO.getLastname());
        profileEntity.setEmail(profileDTO.getEmail());
        profileEntity.setAge(profileDTO.getAge());
        profileEntity.setBirthDate(profileDTO.getBirthDate());
        profileEntity.setSex(profileDTO.getSex());
        profileEntity.setCity(profileDTO.getCity());
        profileEntity.setPhoneNumber(profileDTO.getPhoneNumber());

        return profileEntity;
    }
}
