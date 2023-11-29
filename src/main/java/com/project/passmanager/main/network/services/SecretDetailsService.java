package com.project.passmanager.main.network.services;

import com.project.passmanager.main.algorithms.PasswordGenerator;
import com.project.passmanager.main.algorithms.PasswordSettings;
import com.project.passmanager.main.domain.models.Secret;
import com.project.passmanager.main.domain.repositories.ISecretRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Сущность для работы с иточниками данных для страницы подробной информации о секрете
 * */
@Service
@RequiredArgsConstructor
public class SecretDetailsService {
    private final ISecretRepository secretRepository;

    public List<Secret> getSecretsBySecretSpaceId(@NonNull String secretSpaceId) {
        return secretRepository.getSecretsBySecretSpaceId(secretSpaceId);
    }

    public Secret createEmptySecret(String secretSpaceId) {
        return secretRepository.getTempSecret(secretSpaceId);
    }

    public Secret getSecretById(String id) {
        return secretRepository.getSecretById(id);
    }

    public void saveSecret(Secret secret) {
        secretRepository.saveSecret(secret);
    }

    public void deleteSecret(String id) {
        secretRepository.deleteSecret(id);
    }

    public void createPassword(String secretId, PasswordSettings passwordSettings) {
        var passwordGenerator = new PasswordGenerator();
        var secret = secretRepository.getSecretById(secretId);
        secret.setPassword(passwordGenerator.build(passwordSettings));
        secretRepository.saveSecret(secret);
    }
}
