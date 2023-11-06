package com.project.passmanager.main.database.repositories;

import com.project.passmanager.main.database.core.InMemoryCacheSecrets;
import com.project.passmanager.main.database.mappers.SecretMapper;
import com.project.passmanager.main.domain.models.Secret;
import com.project.passmanager.main.domain.repositories.ISecretRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Реализация репозтория для работы с моделью Secret
 * */
@Component
public class SecretRepositoryImpl implements ISecretRepository {
    @Override
    public List<Secret> getSecrets() {
        return SecretMapper.transformToSecrets(new ArrayList<>(InMemoryCacheSecrets.getSecrets()));
    }

    @Override
    public List<Secret> getSecretsBySecretSpaceId(String secretSpaceId) {
        return SecretMapper.transformToSecrets(InMemoryCacheSecrets.getSecretsBySecretSpaceId(secretSpaceId));
    }

    @Override
    public Secret getSecretById(String id) {
        return SecretMapper.transform(InMemoryCacheSecrets.getSecretById(id));
    }

    @Override
    public Secret getEmptySecret(String secretSpaceId) {
        return SecretMapper.transform(InMemoryCacheSecrets.getEmptySecret(secretSpaceId));
    }

    @Override
    public void saveSecret(Secret secret) {
        InMemoryCacheSecrets.putSecret(SecretMapper.transform(secret));
    }

    @Override
    public void deleteSecret(String id) {
        InMemoryCacheSecrets.deleteSecret(id);
    }
}
