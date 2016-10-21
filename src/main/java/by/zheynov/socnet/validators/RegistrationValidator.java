package by.zheynov.socnet.validators;

import by.zheynov.socnet.entity.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by vazh on 21.10.2016.
 */

@Component
public class RegistrationValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        return UserEntity.class.isAssignableFrom(aClass);
    }

    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"login",
                "registration.page.text.validation.emptylogin", "Login mustn't be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
                "registration.page.text.validation.emptypassword", "password mustn't be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName",
                "registration.page.text.validation.firstName", "First Name mustn't be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName",
                "registration.page.text.validation.lastName", "Last Name mustn't be empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
                "registration.page.text.validation.email", "Email Name mustn't be empty");
    }
}
