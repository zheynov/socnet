package by.zheynov.socnet.facade.converters;

import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.entity.ProfileEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by Redlaw on 27.10.2016.
 */

@Component
public class ProfileDTOReverseConverter implements Converter<ProfileEntity, ProfileDTO> {

    public ProfileDTO convert(ProfileEntity profileEntity) {

        if (profileEntity == null)
            return null;

        ProfileDTO profileDTO = new ProfileDTO();

        profileDTO.setProfileID(profileEntity.getId());
        profileDTO.setFirstName(profileEntity.getFirstName());
        profileDTO.setLastName(profileEntity.getLastName());
        profileDTO.setEmail(profileEntity.getEmail());
        profileDTO.setBirthDate(profileEntity.getBirthDate());
        profileDTO.setAge(profileEntity.getAge());
        profileDTO.setSex(profileEntity.getSex());
        profileDTO.setCity(profileEntity.getCity());
        profileDTO.setPhoneNumber(profileEntity.getPhoneNumber());

        return profileDTO;
    }
}
