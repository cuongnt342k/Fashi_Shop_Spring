package com.ltc.validator;

import com.ltc.dto.UserDTO;
import com.ltc.model.User;
import com.ltc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@PropertySource({
        "classpath:/i18n/validation.properties"
})
public class UserDTOValidator implements Validator {
    @Autowired
    private Environment env;

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDTO userDTO = (UserDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", null, env.getProperty("NotEmpty"));

        if (userDTO.getUsername().length() < 6 || userDTO.getUsername().length() > 32) {
            errors.rejectValue("username", null, env.getProperty("Size.userForm.username"));
        }
        if (userService.findByUserName(userDTO.getUsername()) != null) {
            errors.rejectValue("username",null , env.getProperty("Duplicate.userForm.username"));
        }

        if (userService.findByEmail(userDTO.getEmail()) != null) {
            errors.rejectValue("email",null , env.getProperty("Duplicate.userForm.email"));
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", env.getProperty("NotEmpty"));
        if (userDTO.getPassword().length() < 8 || userDTO.getPassword().length() > 32) {
            errors.rejectValue("password", null, env.getProperty("Size.userForm.password"));
        }

    }
}
