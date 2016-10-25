package by.zheynov.socnet.service.impl;

import by.zheynov.socnet.dao.UserDao;
import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.entity.UserEntity;
import by.zheynov.socnet.service.ProfileService;
import by.zheynov.socnet.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Locale;

/**
 * Created by vazh on 19.10.2016.
 */

@Service("userService")
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
    private UserDao userDao;
    private ProfileService profileService;
    private MessageSource messageSource;

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

        LOGGER.info(messageSource.getMessage("service.user.save", new Object[]{userEntity}, Locale.ENGLISH));
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

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void setProfileService(ProfileService profileService) {
        this.profileService = profileService;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
}
