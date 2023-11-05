package com.project.passmanager.main.domain.repositories;

import com.project.passmanager.main.domain.models.SecretSpace;

import java.util.List;

public interface ISpaceSecretsRepository {
    List<SecretSpace> getSecretSpaces();
}
