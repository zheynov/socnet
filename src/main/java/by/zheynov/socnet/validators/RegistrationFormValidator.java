package by.zheynov.socnet.validators;

import by.zheynov.socnet.dto.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by vazh on 21.10.2016.
 */

@Component("registrationValidator")
public class RegistrationFormValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return UserDTO.class.isAssignableFrom(aClass);
    }

    public void validate(Object targret, Errors errors) {

        UserDTO userDTO = (UserDTO) targret;

        String login = userDTO.getLogin();
        if ((login.length() > 16)) {
            errors.rejectValue("login", "registration.page.text.validation.logintoolong", "Login is too long.");
        } else if ((login.length() < 5)) {
            errors.rejectValue("login", "registration.page.text.validation.logintoshort", "Login is too short");
        }

        String password = userDTO.getPassword();
        if ((password.length()) < 7) {
            errors.rejectValue("password",
                    "registration.page.text.validation.password.length", "Password is too short.");
        }

        String email = userDTO.getEmail();
        if (!EmailValidator.isValidEmailAddress(email)) {
            errors.rejectValue("email", "registration.page.text.validation.emailisnotcorrect", "Email isn't valid");
        }
    }
}
