package com.ali.login.services;

import com.ali.login.dataAcces.abstracts.IUserRepository;
import com.ali.login.forms.RegisterForm;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final IUserRepository userRepository;
    private final PasswordEncoder encoder;

    public AuthService(IUserRepository userRepository, PasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }

    public void add(RegisterForm form){
        form.setPassword(encoder.encode(form.getPassword()));
        this.userRepository.save(form.toEntity(form));
    }

}
