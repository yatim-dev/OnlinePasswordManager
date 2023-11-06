package com.project.passmanager.main.domain.repositories;

import com.project.passmanager.main.domain.models.Secret;

import java.util.List;

/**
 * Репозторий для работы с моделью Secret
 * */
public interface ISecretRepository {
    List<Secret> getSecrets();
    List<Secret> getSecretsBySecretSpaceId(String secretSpaceId);
    Secret getSecretById(String id);
    Secret getEmptySecret(String secretSpaceId);
    void saveSecret(Secret secret);
    void deleteSecret(String id);
}
