package by.zheynov.socnet.controllers;

import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.facade.user.UserFacade;
import by.zheynov.socnet.validators.RegistrationFormValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vazh on 18.10.2016.
 */

@Controller
public class RegistrationController {

    private RegistrationFormValidator registrationFormValidator;
    private UserFacade userFacade;
    public void setUserFacade(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    public void setRegistrationFormValidator(RegistrationFormValidator registrationFormValidator) {
        this.registrationFormValidator = registrationFormValidator;
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String initRegistration(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "/registration";
    }

    @RequestMapping(value = "/registrationComplete", method = RequestMethod.POST)
    public String displayRegistration(Model model,
                                      @ModelAttribute("userDTO") UserDTO userDTO, BindingResult result) {

        registrationFormValidator.validate(userDTO, result);

        if (result.hasErrors())
        {
            return "/registration";
        }

        userFacade.createUser(userDTO);

        return "/loginpage";
    }

    @RequestMapping(value = "/showAllUsers", method = RequestMethod.GET)
    public String showAllTheUsers(Model model) {
        model.addAttribute("allTheUsers", userFacade.getAllTheUsers());
        return "/alltheusers";
    }

}
