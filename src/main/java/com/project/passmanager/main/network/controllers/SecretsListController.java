package com.project.passmanager.main.network.controllers;

import com.project.passmanager.main.domain.Secret;
import com.project.passmanager.main.network.utils.Pages;
import com.project.passmanager.main.network.services.SpaceSecretsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class SecretsListController {
    private final SpaceSecretsService spaceSecretsService;

    @GetMapping("/spaceSecret")
    public String getSpaceSecretPage(Model model) {
        model.addAttribute("secrets", spaceSecretsService.getSecrets());
        return Pages.SECRETS_LIST;
    }

    @GetMapping("/secret/{id}")
    public String secretDetails(@PathVariable String id, Model model) {
       return openSecretPage(model, spaceSecretsService.getSecretById(id));
    }

    @GetMapping("/spaceSecret/createSecret")
    public String createSecret(Model model) {
        return openSecretPage(model, spaceSecretsService.getEmptySecret());
    }

    private String openSecretPage(Model model, Secret secret) {
        model.addAttribute("secret", secret);
        return Pages.SECRET;
    }
}
