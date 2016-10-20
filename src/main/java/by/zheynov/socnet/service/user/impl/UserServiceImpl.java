package by.zheynov.socnet.service.user.impl;

import by.zheynov.socnet.dao.user.UserDao;
import by.zheynov.socnet.entity.UserEntity;
import by.zheynov.socnet.service.user.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by vazh on 19.10.2016.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void createUser(UserEntity userEntity) {
        userDao.createUser(userEntity);
    }
    @Transactional
    public void updateUser(UserEntity user) {
    }
    @Transactional
    public void deleteUser(UserEntity profile) {
    }

    public List<UserEntity> getAllTheUsers() {
        return userDao.getAllTheUsers();
    }


}
