package by.zheynov.socnet.validators;

import by.zheynov.socnet.dto.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by vazh on 21.10.2016.
 */

@Component
public class LoginFormValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return UserDTO.class.isAssignableFrom(aClass);
    }

    public void validate(Object targret, Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login",
                "login.page.text.validation.emptylogin", "Login mustn't be empty.");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "login.page.text.validation.emptypassword", "password mustn't be empty.");
    }
}
