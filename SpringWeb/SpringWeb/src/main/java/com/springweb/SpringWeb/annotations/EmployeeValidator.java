package com.springweb.SpringWeb.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class EmployeeValidator implements ConstraintValidator<EmployeeValidation,String> {
    @Override
    public boolean isValid(String inputRole, ConstraintValidatorContext constraintValidatorContext) {
        if (inputRole == null)
            return false;
        List<String> roles=List.of("USER","ADMIN");
        return  roles.contains(inputRole);
    }
}
