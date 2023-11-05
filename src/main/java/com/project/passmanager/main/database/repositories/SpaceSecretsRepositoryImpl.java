package com.project.passmanager.main.database.repositories;

import com.project.passmanager.main.database.core.InMemoryCacheSecretSpace;
import com.project.passmanager.main.database.mappers.SecretSpaceMapper;
import com.project.passmanager.main.domain.models.SecretSpace;
import com.project.passmanager.main.domain.repositories.ISpaceSecretsRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SpaceSecretsRepositoryImpl implements ISpaceSecretsRepository {

    @Override
    public List<SecretSpace> getSecretSpaces() {
        return InMemoryCacheSecretSpace
                .getSecretSpaces()
                .stream()
                .map(SecretSpaceMapper::transform)
                .toList();
    }

    @Override
    public void saveSecretSpace(SecretSpace secretSpace) {
        InMemoryCacheSecretSpace.saveSecretSpace(SecretSpaceMapper.transform(secretSpace));
    }

    @Override
    public void deleteSecretSpace(String secretSpaceId) {
        InMemoryCacheSecretSpace.deleteSecretSpace(secretSpaceId);
    }
}
