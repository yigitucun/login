package com.ali.login.forms;


import com.ali.login.annotations.auth.UniqueEmail;
import com.ali.login.annotations.auth.UniqueUsername;
import com.ali.login.models.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class RegisterForm {
    @NotBlank(message = "Zorunlu alan")
    @UniqueUsername
    private String username;
    @NotBlank(message = "Zorunlu alan")
    @Email(message = "Geçerli bir e-posta adresi girin.")
    @UniqueEmail
    private String email;
    @NotBlank(message = "Zorunlu alan")
    @Length(min = 6,max = 60,message = "Minimum 6 karakter olmalıdır.")
    private String password;
    private String rePassword;

    public RegisterForm() {
    }

    public User toEntity(RegisterForm form){
        User user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        user.setEmail(form.getEmail());
        return user;
    }

    public RegisterForm(String username, String email, String password, String rePassword) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.rePassword = rePassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password.trim();
    }

    public String getRePassword() {
        return rePassword;
    }

    public void setRePassword(String rePassword) {
        this.rePassword = rePassword.trim();
    }
}
