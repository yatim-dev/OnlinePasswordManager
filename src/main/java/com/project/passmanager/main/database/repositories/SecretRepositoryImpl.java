package com.project.passmanager.main.database.repositories;

import com.project.passmanager.main.database.core.SecretsDAO;
import com.project.passmanager.main.database.mappers.SecretMapper;
import com.project.passmanager.main.domain.models.Secret;
import com.project.passmanager.main.domain.repositories.ISecretRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SecretRepositoryImpl implements ISecretRepository {
    SecretMapper secretMapper;
    SecretsDAO secretsDAO;

    @Override
    public List<Secret> getSecrets(String secretSpaceId) {
        return secretMapper.transformToSecrets(secretsDAO.getSecretsBySecretSpaceId(secretSpaceId));
    }

    @Override
    public List<Secret> getSecretsBySecretSpaceId(String secretSpaceId) {
        return secretMapper.transformToSecrets(secretsDAO.getSecretsBySecretSpaceId(secretSpaceId));
    }

    @Override
    public Secret getSecretById(String id) {
        return secretMapper.transform(secretsDAO.getSecretById(id));
    }

    @Override
    public Secret getEmptySecret(String secretSpaceId) {
        return new Secret(
                UUID.randomUUID().toString(),
                secretSpaceId,
                "",
                "",
                "",
                ""
        );
    }

    @Override
    public void saveSecret(Secret secret) {
        secretsDAO.putSecret(secretMapper.transform(secret));
    }

    @Override
    public void deleteSecret(String id) {
        secretsDAO.getSecretById(id);
    }
}
