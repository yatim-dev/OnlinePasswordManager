package com.project.passmanager.main.network.services;

import com.project.passmanager.main.domain.models.Secret;
import com.project.passmanager.main.domain.models.SecretSpace;
import com.project.passmanager.main.domain.repositories.ISpaceSecretsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpaceSecretsService {
    private final ISpaceSecretsRepository spaceSecretsRepository;

    public List<SecretSpace> getSecretSpaces() {
        var spaces = spaceSecretsRepository.getSecretSpaces();
        spaces.sort(Comparator.comparing(SecretSpace::getName));
        return spaces;
    }

    public SecretSpace getSecretSpaceById(@NonNull String id) {
        return spaceSecretsRepository.getSecretSpaceById(id);
    }

    public List<Secret> getSecretsBySpaceSecretsId(@NonNull String spaceId) {
        if (spaceId.isBlank()) return new ArrayList<>();

        return getSecretSpaceById(spaceId).getSecrets();
    }
}
