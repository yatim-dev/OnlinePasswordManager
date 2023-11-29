package com.project.passmanager.main.network.services;

import com.project.passmanager.main.domain.models.SecretSpace;
import com.project.passmanager.main.domain.repositories.ISpaceSecretsRepository;
import com.project.passmanager.main.domain.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/**
 * Сущность для работы с иточниками данных для страницы пространств с секретами
 * */
@Service
@RequiredArgsConstructor
public class SpaceSecretsService {
    private final ISpaceSecretsRepository spaceSecretsRepository;
    private final IUserRepository userRepository;

    public List<SecretSpace> getSecretSpaces() {
        var spaces = new ArrayList<>(spaceSecretsRepository.getSecretSpaces(userRepository.getCurrentUserId()));
        spaces.sort(Comparator.comparing(SecretSpace::getName));
        return spaces;
    }

    public void saveSecretSpace(SecretSpace secretSpace) {
        secretSpace.setId(UUID.randomUUID().toString());
        spaceSecretsRepository.saveSecretSpace(secretSpace, userRepository.getCurrentUserId());
    }

    public void deleteSecretSpace(String secretSpaceId) {
        spaceSecretsRepository.deleteSecretSpace(secretSpaceId);
    }
}
