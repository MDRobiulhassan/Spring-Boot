package com.springweb.SpringWeb.annotations;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy={EmployeeValidator.class})
public @interface EmployeeValidation {
    java.lang.String message() default "Role Must be USER or ADMIN";

    java.lang.Class<?>[] groups() default {};

    java.lang.Class<? extends jakarta.validation.Payload>[] payload() default {};
}
