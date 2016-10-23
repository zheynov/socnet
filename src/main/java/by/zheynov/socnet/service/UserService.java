package by.zheynov.socnet.service;

import by.zheynov.socnet.entity.UserEntity;

import java.util.List;

/**
 * Created by vazh on 19.10.2016.
 */
public interface UserService {

    void createUser(UserEntity userEntity);

    void updateUser(UserEntity userEntity);

    void deleteUser(UserEntity userEntity);

    List<UserEntity> getAllTheUsers();

/*    boolean isPasswpodlCorrect(UserDTO user);

    boolean isLoginExists(String login);

    boolean isEmailExists(String email);

    UserEntity getUserByLogin(String login);*/
}
