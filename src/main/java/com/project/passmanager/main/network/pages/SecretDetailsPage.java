package com.project.passmanager.main.network.pages;

import com.project.passmanager.main.domain.models.Secret;
import com.project.passmanager.main.network.services.SecretDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

/**
 * Модель содержащая методы и дланные для работы со страницей подробной информации о секретах
 * */
@Component
@RequiredArgsConstructor
public class SecretDetailsPage {
    private static final String PAGE_NAME = "secretPage";

    private final SecretDetailsService secretDetailsService;

    public String openSecretPage(@NonNull String secretId, Model model) {
        model.addAttribute("secret", secretDetailsService.getSecretById(secretId));
        return PAGE_NAME;
    }

    public String openEmptySecretPage(@NonNull String secretSpaceId, Model model) {
        model.addAttribute("secret", secretDetailsService.createEmptySecret(secretSpaceId));
        return PAGE_NAME;
    }

    public String saveSecretAndOpenSpaceSecretPage(
            @NonNull String secretSpaceId,
            @NonNull String secretId,
            Secret secret
    ) {
        secret.setId(secretId);
        secret.setSecretSpaceId(secretSpaceId);
        secretDetailsService.saveSecret(secret);
        return SpaceSecretsPage.redirectOnSelectedSpaceSecretsPage(secretSpaceId);
    }

    public String deleteSecretAndOpenSpaceSecretPage(
            @NonNull String secretSpaceId,
            @NonNull String secretId
    ) {
        secretDetailsService.deleteSecret(secretId);
        return SpaceSecretsPage.redirectOnSelectedSpaceSecretsPage(secretSpaceId);
    }
}
