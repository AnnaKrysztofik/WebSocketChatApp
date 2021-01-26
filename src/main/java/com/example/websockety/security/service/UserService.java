package com.example.websockety.security.service;
import com.example.websockety.security.entity.AppUser;
import com.example.websockety.security.repo.AppUserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class UserService {

    private AppUserRepo appUserRepo;
    private PasswordEncoder passwordEncoder;
    protected final Logger log = LoggerFactory.getLogger(getClass());

    public UserService(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder) {
        this.appUserRepo = appUserRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean usernameTaken(AppUser appUser, Model model){
        if (appUserRepo.findByUsername(appUser.getUsername()) == null) {
           log.info("Login is available");
           return false;
       }
        log.warn("Login is taken");
        model.addAttribute("error", "Podany login jest już zajęty");
       return true;
    };

    public String addUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser.setEnabled(true);
        appUser.setRole("ROLE_USER");
        appUserRepo.save(appUser);
        return "Registration Successful\n" +
                "Thank you for registering.";
    }
}
