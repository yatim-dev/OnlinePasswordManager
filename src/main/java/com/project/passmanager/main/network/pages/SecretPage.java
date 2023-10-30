package com.project.passmanager.main.network.pages;

import com.project.passmanager.main.domain.models.Secret;
import com.project.passmanager.main.network.services.SecretService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
@RequiredArgsConstructor
public class SecretPage {
    private static final String PAGE_NAME = "secretPage";

    private final SecretService secretService;

    public String openSecretPage(@NonNull String secretId, Model model) {
        model.addAttribute("secret", secretService.getSecretById(secretId));
        return PAGE_NAME;
    }

    public String openEmptySecretPage(Model model) {
        return openSecretPage("", model);
    }

    public String saveSecretAndOpenSpaceSecretPage(@NonNull String secretId, Secret secret) {
        secret.setId(secretId);
        secretService.saveSecret(secret);
        return SpaceSecretsPage.REDIRECT_ON_PAGE;
    }

    public String deleteSecretAndOpenSpaceSecretPage(@NonNull String secretId) {
        secretService.deleteSecret(secretId);
        return SpaceSecretsPage.REDIRECT_ON_PAGE;
    }
}
