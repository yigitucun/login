package com.ali.login.annotations.auth;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueEmail {
    String message() default "E-posta adresi önceden alınmış";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
