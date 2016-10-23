package by.zheynov.socnet.dao;

import by.zheynov.socnet.entity.UserEntity;

import java.util.List;

/**
 * Created by vazh on 19.10.2016.
 */

public interface UserDao {

    UserEntity createUser(UserEntity user);

    void updateUser(UserEntity user);

    void deleteUser(UserEntity user);

    List<UserEntity> getAllTheUsers();

/*    boolean isLoginExists(String login);

    boolean isUserPasswpodlCorrect(UserDTO user);

    boolean isEmailExists(String email);

    UserEntity getUserByLogin(String login);*/
}
