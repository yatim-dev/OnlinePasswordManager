package com.project.passmanager.main.domain.repositories;

import com.project.passmanager.main.domain.models.DomainUser;

import java.util.List;

public interface IUserRepository {
    List<DomainUser> getAllUsers();

    DomainUser getUser(String userId);

    DomainUser getEmptyUser();

    DomainUser getUserByLogin(String login);

    void saveUser(DomainUser user);

    void deleteUser(String userId);

    String getCurrentUserId();
}
