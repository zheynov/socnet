package by.zheynov.socnet.controllers;

import by.zheynov.socnet.dto.UserDTO;
import by.zheynov.socnet.validators.LoginValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by vazh on 19.10.2016.
 */

@Controller
public class LoginController {

    private LoginValidator loginValidator;

    public void setLoginValidator(LoginValidator loginValidator) {
        this.loginValidator = loginValidator;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String initLogin(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "/loginpage";
    }

    @RequestMapping(value = "/processLogin", method = RequestMethod.POST)
    public String processLogin(Model model, HttpSession session,
                               @ModelAttribute("userDTO") UserDTO userDTO, BindingResult result) {

        loginValidator.validate(userDTO, result);

        if (result.hasErrors())
            return "/loginpage";

        session.setAttribute("userDTO", userDTO);

        return "redirect:/showAllUsers";
    }


}
