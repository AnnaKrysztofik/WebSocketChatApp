package com.example.websockety.security.rest;
import com.example.websockety.security.service.UserService;
import com.example.websockety.security.entity.AppUser;
import com.example.websockety.security.repo.AppUserRepo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.Collection;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService, AppUserRepo appUserRepo) {
        this.userService = userService;
    }
 //@CrossOrigin(origins = "http://localhost:8080")
  @CrossOrigin(origins = "http://websocketchatapps.herokuapp.com")
    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

 // @CrossOrigin(origins = "http://localhost:8080")
 @CrossOrigin(origins = "http://websocketchatapps.herokuapp.com")
    @GetMapping("/")
    public String chat(Principal principal, Model model) {
        model.addAttribute("name", principal.getName());
        Collection<? extends GrantedAuthority> authorities = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
        Object details = SecurityContextHolder.getContext().getAuthentication().getDetails();
        model.addAttribute("authorities", authorities);
        model.addAttribute("details", details);
        return "index";
    }
 //  @CrossOrigin(origins = "http://localhost:8080")
  @CrossOrigin(origins = "http://websocketchatapps.herokuapp.com")
    @GetMapping("/sign-up")
    public String singUp(Model model) {
       AppUser newAppUser = new AppUser();
       model.addAttribute("user", newAppUser);
       return "sign-up";
    }

    @PostMapping("/register")
    public String register(AppUser appUser, Model model) {
        if (userService.usernameTaken(appUser, model) == true) {
        return "sign-up";
        }
        else {
            userService.addUser(appUser);
            return "login";
        }
    }

}
