package by.zheynov.socnet.dao;

import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.entity.UserEntity;

import java.util.List;


public interface UserDao {

    UserEntity createUser(UserEntity user);

    void updateUser(UserEntity user);

    void deleteUser(UserEntity user);

    UserEntity getUserByLogin(String login);

    List<UserEntity> getAllTheUsers();

    boolean isLoginExists(String login);

    boolean isUserPasswpodlCorrect(UserDTO user);

    boolean isEmailExists(String email);

}
