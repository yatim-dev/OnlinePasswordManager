package com.project.passmanager.main.network.controllers;

import com.project.passmanager.main.domain.models.Secret;
import com.project.passmanager.main.network.pages.SecretPage;
import com.project.passmanager.main.network.pages.SpaceSecretsPage;
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

    @PostMapping("/secret/save/{secretSpaceId}/{secretId}")
    public String saveData(@PathVariable String secretSpaceId, @PathVariable String secretId, Secret secret) {
        return secretPage.saveSecretAndOpenSpaceSecretPage(secretSpaceId, secretId, secret);
    }

    @PostMapping("/secret/delete/{secretSpaceId}/{id}")
    public String deleteSecret(@PathVariable String secretSpaceId, @PathVariable String id) {
        return secretPage.deleteSecretAndOpenSpaceSecretPage(secretSpaceId, id);
    }

    @GetMapping("/secret/{id}")
    public String secretDetails(@PathVariable String id, Model model) {
        return secretPage.openSecretPage(id, model);
    }

    @GetMapping("/spaceSecret/createSecret")
    public String createSecret(Model model) {
        if (!SpaceSecretsPage.SELECTED_SECRET_SPACE_ID.isBlank()) {
            return secretPage.openEmptySecretPage(SpaceSecretsPage.SELECTED_SECRET_SPACE_ID, model);
        } else {
            return SpaceSecretsPage.refreshPage();
        }
    }
}
