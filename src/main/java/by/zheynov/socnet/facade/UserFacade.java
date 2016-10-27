package by.zheynov.socnet.facade;

import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.entity.UserEntity;

import java.util.List;

/**
 * Created by vazh on 21.10.2016.
 */
public interface UserFacade {

    void createUser(UserDTO userDTO);

    void updateUser(UserDTO userDTO);

    void deleteUser(UserDTO userDTO);

    UserEntity getUserByLogin(String login);

    List<UserDTO> getAllTheUsers();

    boolean isLoginExists(String login);

    boolean isUserPasswpodlCorrect(UserDTO user);

    boolean isEmailExists(String email);
}
