package com.project.passmanager.main.database.mappers;

import com.project.passmanager.main.database.models.UserEntity;
import com.project.passmanager.main.domain.models.DomainUser;

import java.util.List;

public class UserMapper {
    public UserEntity transform(DomainUser user) {
        return new UserEntity(
                user.getId(),
                user.getLogin(),
                user.getHashPassword()
        );
    }

    public List<UserEntity> transformToSecretsEntity(List<DomainUser> secrets) {
        return secrets
                .stream()
                .map(this::transform)
                .toList();
    }

    public DomainUser transform(UserEntity userEntity) {
        return new DomainUser(
                userEntity.getId(),
                userEntity.getLogin(),
                userEntity.getHashPassword()
        );
    }

    public List<DomainUser> transformToUsers(List<UserEntity> userEntities) {
        return userEntities
                .stream()
                .map(this::transform)
                .toList();
    }
}
