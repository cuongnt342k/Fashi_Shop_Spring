package com.ltc.validator;

import com.ltc.dto.OrderDTO;
import com.ltc.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PaymentValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return OrderDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
