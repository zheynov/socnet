package by.zheynov.socnet.service.user;

import by.zheynov.socnet.entity.UserEntity;

/**
 * Created by vazh on 19.10.2016.
 */
public interface UserService {

    void createUser(UserEntity userEntity);

    void updateUser(UserEntity userEntity);

    void deleteUser(UserEntity userEntity);

/*    boolean isPasswpodlCorrect(UserDTO user);

    boolean isLoginExists(String login);

    boolean isEmailExists(String email);

    UserEntity getUserByLogin(String login);*/
}
