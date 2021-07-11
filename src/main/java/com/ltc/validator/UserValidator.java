package com.ltc.validator;

import com.ltc.model.User;
import com.ltc.services.UserService;
import com.ltc.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@PropertySource({
        "classpath:i18n/validation.properties"
})
public class UserValidator implements Validator {
    @Autowired
    private Environment env;

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", env.getProperty("NotEmpty"));
        if (user.getUsername().length() < 6 || user.getUsername().length() > 32) {
            errors.rejectValue("username", env.getProperty("Size.userForm.username"));
        }
        if (userService.findByUserNameAndStatus(user.getUsername(),Const.STATUS.ACTIVCE) != null) {
            errors.rejectValue("username", env.getProperty("Duplicate.userForm.username"));
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", env.getProperty("NotEmpty"));
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", env.getProperty("Size.userForm.password"));
        }

        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", env.getProperty("Diff.userForm.passwordConfirm"));
        }
    }
}