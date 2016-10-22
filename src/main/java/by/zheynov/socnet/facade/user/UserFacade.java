package by.zheynov.socnet.facade.user;

import by.zheynov.socnet.dto.UserDTO;
import java.util.List;

/**
 * Created by vazh on 21.10.2016.
 */
public interface UserFacade {

    void createUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUser(UserDTO userDTO);

    List<UserDTO> getAllTheUsers();
}
