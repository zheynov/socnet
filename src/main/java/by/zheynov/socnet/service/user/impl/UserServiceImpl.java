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
    public void createUser(final UserEntity userEntity) {
        userDao.createUser(userEntity);
    }

    @Transactional
    public void updateUser(final UserEntity user) {
    }

    @Transactional
    public void deleteUser(final UserEntity profile) {
    }

    public List<UserEntity> getAllTheUsers() {
        return userDao.getAllTheUsers();
    }


}
