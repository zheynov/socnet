package by.zheynov.socnet.service.impl;

import by.zheynov.socnet.dao.UserDao;
import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.entity.UserEntity;
import by.zheynov.socnet.service.PasswordEncoding;
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
        userEntity.setPassword(PasswordEncoding.encodePassword(userEntity.getPassword()));
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

    public boolean isPasswpodlCorrect(UserDTO userDTO) {
        return userDao.isUserPasswpodlCorrect(userDTO);
    }

    public boolean isLoginExists(String login) {
        return userDao.isLoginExists(login);
    }

    public boolean isEmailExists(String email) {
        return userDao.isEmailExists(email);
    }

    public UserEntity getUserByLogin(String login) {
        return null;
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
