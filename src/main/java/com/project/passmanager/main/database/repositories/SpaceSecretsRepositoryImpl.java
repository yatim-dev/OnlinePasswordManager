package com.project.passmanager.main.database.repositories;

import com.project.passmanager.main.database.core.InMemoryCacheSecretSpace;
import com.project.passmanager.main.domain.models.SecretSpace;
import com.project.passmanager.main.domain.repositories.ISpaceSecretsRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpaceSecretsRepositoryImpl implements ISpaceSecretsRepository {

    @Override
    public List<SecretSpace> getSecretSpaces() {
        return InMemoryCacheSecretSpace.getSecretSpaces();
    }

    @Override
    public SecretSpace getSecretSpaceById(String id) {
        return InMemoryCacheSecretSpace.getSecretSpaceById(id);
    }
}
