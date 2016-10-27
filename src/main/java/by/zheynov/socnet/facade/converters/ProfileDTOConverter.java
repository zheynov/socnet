package by.zheynov.socnet.facade.converters;

import by.zheynov.socnet.dto.ProfileDTO;
import by.zheynov.socnet.entity.ProfileEntity;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by Redlaw on 27.10.2016.
 */
public class ProfileDTOConverter implements Converter<ProfileDTO, ProfileEntity> {

   public ProfileEntity convert(ProfileDTO source) {
        return null;
    }
}
