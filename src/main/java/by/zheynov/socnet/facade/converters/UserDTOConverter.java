package by.zheynov.socnet.facade.converters;

import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.entity.UserEntity;
import org.springframework.core.convert.converter.Converter;

/**
 * Created by ZheynovVV on 22.10.2016.
 */

public class UserDTOConverter implements Converter<UserDTO, UserEntity> {

    public UserEntity convert(UserDTO userDTO) {

        UserEntity userEntity = new UserEntity();

        userEntity.setId(userDTO.getId());
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setLogin(userDTO.getLogin());
        userEntity.setPassword(userDTO.getPassword());

        return userEntity;
    }
}
