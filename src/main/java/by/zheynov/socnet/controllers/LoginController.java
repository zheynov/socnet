package by.zheynov.socnet.controllers;

import by.zheynov.socnet.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by vazh on 19.10.2016.
 */

@Controller
public class LoginController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String initLogin(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "/loginpage";
    }


}
