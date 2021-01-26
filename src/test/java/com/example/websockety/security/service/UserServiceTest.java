package com.example.websockety.security.service;

import com.example.websockety.security.entity.AppUser;
import com.example.websockety.security.repo.AppUserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class UserServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private AppUserRepo appUserRepo;

    @Test
    void usernameTaken() {
        //Arrange

        //Act

        //Assert
    }

    @Test
    void addUser() {
        //Arrange
        AppUser appUser = new AppUser();
        appUser.setUsername("Ania");
        appUser.setPassword("12345");
        //Act
        userService.addUser(appUser);

        //Assert
        assertTrue(appUserRepo.findByUsername("Ania").isEnabled());
        assertTrue(appUserRepo.findByUsername("Zuzia")==null);

    }
}