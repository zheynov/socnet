package by.zheynov.socnet.controllers;

import by.zheynov.socnet.entity.ProfileEntity;
import by.zheynov.socnet.entity.UserEntity;
import by.zheynov.socnet.service.profile.ProfileService;
import by.zheynov.socnet.service.profile.impl.ProfileServiceImpl;
import by.zheynov.socnet.service.user.UserService;
import by.zheynov.socnet.service.user.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vazh on 18.10.2016.
 */

@Controller
public class RegistrationController {

    private UserService userService;
    private ProfileService profileService;

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public void setProfileService(ProfileService profileService) {
        this.profileService = profileService;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String initRegistration(Model model) {
        model.addAttribute("UserEntity", new UserEntity());
        return "/registration";
    }

    @RequestMapping(value = "/registrationComplete", method = RequestMethod.POST)
    public String displayRegistration(Model model, UserEntity userEntity) {

        ProfileEntity profileEntity = new ProfileEntity();
        profileEntity.setUser(userEntity);
        profileEntity.setFirstName(userEntity.getFirstName());
        profileEntity.setLastName(userEntity.getLastName());
        profileEntity.setEmail(userEntity.getEmail());
        userEntity.setProfileEntity(profileEntity);

        profileService.createProfile(profileEntity);
        userService.createUser(userEntity);

        return "/loginpage";
    }

    @RequestMapping(value = "/showAllUsers", method = RequestMethod.GET)
    public String showAllTheUsers(Model model) {
        model.addAttribute("allTheUsers", userService.getAllTheUsers());
        return "/alltheusers";
    }

}
