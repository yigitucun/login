package com.ali.login.annotations.auth;

import com.ali.login.dataAcces.abstracts.IUserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Service;

@Service
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail,String> {
    private final IUserRepository userRepository;

    public UniqueEmailValidator(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !this.userRepository.existsByEmail(value);
    }

}
