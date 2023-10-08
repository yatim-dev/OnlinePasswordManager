package com.project.passmanager.main.network.services;

import com.project.passmanager.main.domain.repositories.ISecretRepository;
import com.project.passmanager.main.domain.models.Secret;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
@RequiredArgsConstructor
public class SpaceSecretsService {
    private final ISecretRepository secretRepository;

    public Collection<Secret> getSecrets() {
        return secretRepository.getSecrets();
    }

    public Secret getSecretById(String id) {
        return secretRepository.getSecretById(id);
    }

    public Secret getEmptySecret() {
        return secretRepository.getEmptySecret();
    }

    public void saveSecret(Secret secret) {
        secretRepository.saveSecret(secret);
    }

    public void deleteSecret(String id) {
        secretRepository.deleteSecret(id);
    }
}
