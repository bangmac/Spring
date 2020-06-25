package com.codegym.validator;

import com.codegym.model.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PhoneNumValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        String phoneNum = (String) target;
        ValidationUtils.rejectIfEmpty(errors, "phoneNum", "phoneNum.empty");
        if (phoneNum.length() > 11 || phoneNum.length() < 10) {
            errors.rejectValue("phoneNum", "phoneNum.length");
        }
        if (!phoneNum.startsWith("0")) {
            errors.rejectValue("phoneNum", "phoneNum.startsWith");
        }
        if (!phoneNum.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("phoneNum", "phoneNum.matches");
        }
    }
}
