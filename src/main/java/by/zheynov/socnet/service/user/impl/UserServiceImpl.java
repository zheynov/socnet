package by.zheynov.socnet.service.user.impl;

import by.zheynov.socnet.dao.user.UserDao;
import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.entity.UserEntity;
import by.zheynov.socnet.service.profile.impl.ProfileServiceImpl;
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
    private ProfileServiceImpl profileService;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setProfileService(ProfileServiceImpl profileService) {
        this.profileService = profileService;
    }

    @Transactional
    public void createUser(final UserEntity userEntity) {

        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setUser(userEntity);
        profileEntity.setFirstName(userEntity.getFirstName());
        profileEntity.setLastName(userEntity.getLastName());
        profileEntity.setEmail(userEntity.getEmail());
        userEntity.setProfileEntity(profileEntity);

        profileService.createProfile(profileEntity);
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
