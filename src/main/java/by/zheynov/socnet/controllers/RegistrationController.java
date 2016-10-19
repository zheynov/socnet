package by.zheynov.socnet.controllers;

import by.zheynov.socnet.entity.UserEntity;
import by.zheynov.socnet.service.user.UserService;
import by.zheynov.socnet.service.user.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *  Created by vazh on 18.10.2016.
 */

@Controller
public class RegistrationController {

    private UserService userService;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String initRegistration(Model model) {
        model.addAttribute("UserEntity", new UserEntity());
        return "/registration";
    }

    @RequestMapping(value = "/regComplete", method = RequestMethod.POST)
    public String displayRegistration(Model model, UserEntity userEntity) {

        userService.createUser(userEntity);
        return "loginpage";
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }
}
