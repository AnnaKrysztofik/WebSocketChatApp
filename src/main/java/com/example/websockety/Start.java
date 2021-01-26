package com.example.websockety;

import com.example.websockety.security.entity.AppUser;
import com.example.websockety.security.repo.AppUserRepo;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Start {
    private AppUserRepo appUserRepo;

    public Start(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder) {
        this.appUserRepo = appUserRepo;

        AppUser appUserTest = new AppUser();
        appUserTest.setUsername("Ania");
        appUserTest.setPassword(passwordEncoder.encode("123"));
        appUserTest.setRole("ROLE_USER");
        appUserTest.setEnabled(true);
        appUserRepo.save(appUserTest);
    }
}
