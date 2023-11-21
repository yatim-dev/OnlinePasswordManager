package com.project.passmanager.main.database.repositories;

import com.project.passmanager.main.database.core.SecretSpaceDAO;
import com.project.passmanager.main.database.mappers.SecretSpaceMapper;
import com.project.passmanager.main.domain.models.SecretSpace;
import com.project.passmanager.main.domain.repositories.ISpaceSecretsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;


@Component
@RequiredArgsConstructor
public class SpaceSecretsRepositoryImpl implements ISpaceSecretsRepository {
    @Autowired
    private final SecretSpaceMapper secretSpaceMapper;
    @Autowired
    private final SecretSpaceDAO secretsSpaceDAO;

    @Override
    public List<SecretSpace> getSecretSpaces(String userId) {
        return secretSpaceMapper
                .transformToSecretSpaces(secretsSpaceDAO
                        .getSecretSpacesByUserId(userId)
                );
    }

    @Override
    public SecretSpace getEmptySecretSpace(String userId) {
        return new SecretSpace(
                UUID.randomUUID().toString(),
                userId,
                ""
        );
    }

    @Override
    public void saveSecretSpace(SecretSpace secretSpace) {
        secretsSpaceDAO
                .putSecretSpaceByUser(
                        secretSpaceMapper
                                .transform(secretSpace)
                );
    }

    @Override
    public void deleteSecretSpace(String secretSpaceId) {
        secretsSpaceDAO.deleteSecretSpaceById(secretSpaceId);
    }
}
