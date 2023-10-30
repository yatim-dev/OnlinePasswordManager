package com.project.passmanager.main.network.controllers;

import com.project.passmanager.main.domain.models.Secret;
import com.project.passmanager.main.network.pages.SecretPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SecretController {
    private final SecretPage secretPage;

    @PostMapping("/secret/save/{id}")
    public String saveData(@PathVariable String id, Secret secret) {
        return secretPage.saveSecretAndOpenSpaceSecretPage(id, secret);
    }

    @PostMapping("/secret/delete/{id}")
    public String deleteSecret(@PathVariable String id) {
        return secretPage.deleteSecretAndOpenSpaceSecretPage(id);
    }

    @GetMapping("/secret/{id}")
    public String secretDetails(@PathVariable String id, Model model) {
        return secretPage.openSecretPage(id, model);
    }

    @GetMapping("/spaceSecret/createSecret")
    public String createSecret(Model model) {
        return secretPage.openEmptySecretPage(model);
    }
}
