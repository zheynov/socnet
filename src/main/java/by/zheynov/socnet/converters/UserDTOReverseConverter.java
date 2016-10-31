package by.zheynov.socnet.converters;

import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.entity.UserEntity;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by ZheynovVV on 22.10.2016.
 */

@Component
public class UserDTOReverseConverter implements Converter<UserDTO, UserEntity> {

    public UserEntity convert(UserDTO userDTO) {

        UserEntity userEntity = new UserEntity();

        userEntity.setEnabled(userDTO.isEnabled());
        userEntity.setId(userDTO.getId());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());

        return userEntity;
    }
}
