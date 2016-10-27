package by.zheynov.socnet.controllers;

import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.facade.UserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vazh on 18.10.2016.
 */

@Controller
public class RegistrationController {

    @Autowired
    @Qualifier("registrationValidator")
    private Validator registrationValidator;
    @Autowired
    private UserFacade userFacade;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String initRegistration(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "/registration";
    }

    @RequestMapping(value = "/registrationComplete", method = RequestMethod.POST)
    public String displayRegistration(Model model,
                                      @ModelAttribute("userDTO") UserDTO userDTO, BindingResult result) {

        registrationValidator.validate(userDTO, result);

        if (result.hasErrors()) {
            return "/registration";
        }

        if (!userFacade.isLoginExists(userDTO.getLogin())) {
            if (!userFacade.isEmailExists(userDTO.getEmail())) {

                userFacade.createUser(userDTO);
                return "/loginpage";

            } else {
                model.addAttribute("pageNotification", "email");
                return "/registration";
            }
        } else {
            model.addAttribute("pageNotification", "login");
            return "/registration";
        }
    }

    @RequestMapping(value = "/showAllUsers", method = RequestMethod.GET)
    public String showAllTheUsers(Model model) {
        model.addAttribute("allTheUsers", userFacade.getAllTheUsers());
        return "/alltheusers";
    }

}
