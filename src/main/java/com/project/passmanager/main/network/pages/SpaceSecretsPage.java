package com.project.passmanager.main.network.pages;

import com.project.passmanager.main.network.services.SpaceSecretsService;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
@RequiredArgsConstructor
public class SpaceSecretsPage {
    private static final String PAGE_NAME = "secretsListPage";
    static final String REDIRECT_ON_PAGE = "redirect:/spaceSecret";

    private final SpaceSecretsService spaceSecretsService;

    public String openSecretsListPage(@NonNull String spaceId, Model model) {
        model.addAttribute("spaces", spaceSecretsService.getSecretSpaces());
        model.addAttribute("secrets", spaceSecretsService.getSecretsBySpaceSecretsId(spaceId));
        return PAGE_NAME;
    }

    public String openEmptySecretsListPage(Model model) {
        return openSecretsListPage("", model);
    }
}
