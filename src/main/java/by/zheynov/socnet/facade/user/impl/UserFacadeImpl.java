package by.zheynov.socnet.facade.user.impl;

import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.entity.UserEntity;
import by.zheynov.socnet.facade.converters.UserDTOToUserEntityConverter;
import by.zheynov.socnet.facade.user.UserFacade;
import by.zheynov.socnet.service.user.UserService;
import java.util.ArrayList;
import java.util.List;

/**
 *  Created by vazh on 21.10.2016.
 */

public class UserFacadeImpl implements UserFacade {

    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    UserDTOToUserEntityConverter converter = new UserDTOToUserEntityConverter();




    public void createUser(UserDTO userDTO) {
        userService.createUser(converter.convert(userDTO));
    }

    public void updateUser(UserDTO userEntity) {

    }

    public void deleteUser(UserDTO userEntity) {

    }

    public List<UserDTO> getAllTheUsers() {

        List<UserDTO> allTheDTOUsers = new ArrayList<UserDTO>();
        for (UserEntity userEntity : userService.getAllTheUsers()) {

      //      allTheDTOUsers.add( );

        }


        return allTheDTOUsers;
    }


}
