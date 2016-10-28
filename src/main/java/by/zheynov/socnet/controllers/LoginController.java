package by.zheynov.socnet.controllers;

import by.zheynov.socnet.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vazh on 19.10.2016.
 */

@Controller
public class LoginController {

  @Autowired
    @Qualifier("loginFormValidator")
    private Validator loginFormValidator;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String initLogin(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "/loginpage";
    }


/*  /*
    @RequestMapping(value = "/processLogin", method = RequestMethod.POST)
    public String processLogin(Model model, HttpSession session,
                               @ModelAttribute("userDTO") UserDTO userDTO, BindingResult result) {

        loginFormValidator.validate(userDTO, result);

        if (result.hasErrors())
            return "/loginpage";

//        session.setAttribute("userDTO", userDTO);

        return "redirect:/showAllUsers";
    }*/

}
