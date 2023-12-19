package com.project.passmanager.main.network.controllers;

import com.project.passmanager.main.domain.models.DomainUser;
import com.project.passmanager.main.network.pages.SpaceSecretsPage;
import com.project.passmanager.main.network.services.UserRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;
import java.util.UUID;

@RequiredArgsConstructor
@Controller
public class RegistrationController {
    private final UserRegistrationService userRegistrationService;
    private final PasswordEncoder passwordEncoder;
    private final String REGISTRATION_PAGE = "registration";

    /**
     * Метод отправляет шаблон регистрации на клиента, когда обращаемся к регистрации
     */
    @GetMapping("/registration")
    public String registration() {
        return REGISTRATION_PAGE;
    }


    //TODO: salt
    /**
     * Метод сохранения формы регистрации
     */
    @PostMapping("/registration")
    public String adduser(DomainUser domainUser, Model model) {
        try {
            domainUser.setId(UUID.randomUUID().toString());
            domainUser.setSaltNum(String.valueOf(new Random().nextInt()));
            domainUser.setHashPassword(passwordEncoder.encode(domainUser.getHashPassword()));
            userRegistrationService.addUser(domainUser);
            return SpaceSecretsPage.redirect();
        } catch (Exception ex) {
            model.addAttribute("message", "UserRegistration exists");
            return REGISTRATION_PAGE;
        }
    }

}
