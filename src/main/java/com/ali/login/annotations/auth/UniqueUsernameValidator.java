package com.ali.login.annotations.auth;

import com.ali.login.dataAcces.abstracts.IUserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Service;

@Service
public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername,String> {

    private final IUserRepository userRepository;

    public UniqueUsernameValidator(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !this.userRepository.existsByUsername(value);
    }
}
