package com.project.passmanager.main.network.services;

import com.project.passmanager.main.domain.models.Secret;
import com.project.passmanager.main.domain.repositories.ISecretRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SecretService {
    private final ISecretRepository secretRepository;

    public Secret createEmptySecret(String secretSpaceId) {
        return secretRepository.getEmptySecret(secretSpaceId);
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
}
