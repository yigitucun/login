package com.ali.login.annotations.auth;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueUsernameValidator.class)
public @interface UniqueUsername {
    String message() default "Kullanıcı adı önceden alınmış.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
