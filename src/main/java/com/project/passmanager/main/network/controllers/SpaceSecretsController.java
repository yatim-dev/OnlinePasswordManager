package com.project.passmanager.main.network.controllers;

import com.project.passmanager.main.network.pages.SpaceSecretsPage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class SpaceSecretsController {
    private final SpaceSecretsPage spaceSecretsPage;

    @GetMapping("/spaceSecret")
    public String getSpaceSecretPage(Model model) {
        return spaceSecretsPage.openEmptySecretsListPage(model);
    }

    @GetMapping("/spaceSecret/{spaceId}")
    public String getSpaceSecretPage(@PathVariable String spaceId, Model model) {
        SpaceSecretsPage.SELECTED_SECRET_SPACE_ID = spaceId;
        return spaceSecretsPage.openSecretsListPage(spaceId, model);
    }
}
