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

    public String openEmptySecretPage(@NonNull String secretSpaceId, Model model) {
        model.addAttribute("secret", secretService.createEmptySecret(secretSpaceId));
        return PAGE_NAME;
    }

    public String saveSecretAndOpenSpaceSecretPage(
            @NonNull String secretSpaceId,
            @NonNull String secretId,
            Secret secret
    ) {
        secret.setId(secretId);
        secret.setSecretSpaceId(secretSpaceId);
        secretService.saveSecret(secret);
        return SpaceSecretsPage.redirectOnSelectedSpaceSecretsPage(secretSpaceId);
    }

    public String deleteSecretAndOpenSpaceSecretPage(
            @NonNull String secretSpaceId,
            @NonNull String secretId
    ) {
        secretService.deleteSecret(secretId);
        return SpaceSecretsPage.redirectOnSelectedSpaceSecretsPage(secretSpaceId);
    }
}
