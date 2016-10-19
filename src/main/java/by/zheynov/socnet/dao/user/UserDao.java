package by.zheynov.socnet.dao.user;

import by.zheynov.socnet.entity.UserEntity;

/**
 * Created by vazh on 19.10.2016.
 */

public interface UserDao {

    UserEntity createUser(UserEntity user);

    void updateUser(UserEntity user);

    void deleteUser(UserEntity user);

/*    boolean isLoginExists(String login);

    boolean isUserPasswpodlCorrect(UserDTO user);

    boolean isEmailExists(String email);

    UserEntity getUserByLogin(String login);*/
}
