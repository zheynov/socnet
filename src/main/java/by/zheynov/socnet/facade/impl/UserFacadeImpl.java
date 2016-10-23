package by.zheynov.socnet.facade.impl;

import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.entity.UserEntity;
import by.zheynov.socnet.facade.converters.UserDTOConverter;
import by.zheynov.socnet.facade.converters.UserDTOReverseConverter;
import by.zheynov.socnet.facade.UserFacade;
import by.zheynov.socnet.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vazh on 21.10.2016.
 */

public class UserFacadeImpl implements UserFacade {

    private UserService userService;
    private UserDTOConverter userDTOConverter = new UserDTOConverter();
    private UserDTOReverseConverter userDTOReverseConverter = new UserDTOReverseConverter();

    public void createUser(UserDTO userDTO) {
        userService.createUser(userDTOConverter.convert(userDTO));
    }

    public void updateUser(UserDTO userEntity) {
    }

    public void deleteUser(UserDTO userEntity) {
    }

    public List<UserDTO> getAllTheUsers() {

        List<UserDTO> allTheDTOUsers = new ArrayList<UserDTO>();
        for (UserEntity userEntity : userService.getAllTheUsers()) {
            allTheDTOUsers.add(userDTOReverseConverter.convert(userEntity));
        }
        return allTheDTOUsers;
    }


    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
