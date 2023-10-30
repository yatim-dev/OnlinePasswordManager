package com.project.passmanager.main.network.controllers;

import com.project.passmanager.main.domain.models.Secret;
import com.project.passmanager.main.network.services.SecretService;
import com.project.passmanager.main.network.utils.Pages;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SecretController {
    private final SecretService secretService;

    @PostMapping("/secret/save/{id}")
    public String saveData(@PathVariable String id, Secret secret) {
        secret.setId(id);
        secretService.saveSecret(secret);
        return Pages.redirectToSecretsList();
    }

    @PostMapping("/secret/delete/{id}")
    public String deleteSecret(@PathVariable String id) {
        secretService.deleteSecret(id);
        return Pages.redirectToSecretsList();
    }

    @PostMapping("/secret/passwordGeneration")
    public String openPageGeneratePassword(String id) {
        return Pages.PASSWORD_GENERATION;
    }

    @GetMapping("/secret/{id}")
    public String secretDetails(@PathVariable String id, Model model) {
        return openSecretPage(model, secretService.getSecretById(id));
    }

    @GetMapping("/spaceSecret/createSecret")
    public String createSecret(Model model) {
        return openSecretPage(model, secretService.getEmptySecret());
    }

    private String openSecretPage(Model model, Secret secret) {
        model.addAttribute("secret", secret);
        return Pages.SECRET;
    }
}
