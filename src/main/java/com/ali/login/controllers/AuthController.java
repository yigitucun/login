package com.ali.login.controllers;

import com.ali.login.forms.LoginForm;
import com.ali.login.forms.RegisterForm;
import com.ali.login.services.AuthService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

    private AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String login(Model model){
        LoginForm form = new LoginForm();
        model.addAttribute("form",form);
        return "auth/login/index";
    }

    @GetMapping("/register")
    public String register(Model model){
        RegisterForm registerForm = new RegisterForm();
        model.addAttribute("form",registerForm);
        return "auth/register/index";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("form") RegisterForm form, BindingResult result){
        if (!form.getPassword().equals(form.getRePassword())) {
            result.rejectValue("rePassword", "Şifreler uyuşmuyor", "Şifreler uyuşmuyor");
        }
        if (result.hasErrors()){
            return "auth/register/index";
        }
        this.authService.add(form);
        return "redirect:/";
    }

}
