package com.project.passmanager.main.database.repositories;

import com.project.passmanager.main.database.core.UsersDAO;
import com.project.passmanager.main.database.mappers.UserMapper;
import com.project.passmanager.main.domain.models.DomainUser;
import com.project.passmanager.main.domain.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl implements IUserRepository {
    UserMapper userMapper;
    UsersDAO usersDAO;

    @Autowired
    public UserRepositoryImpl(UserMapper userMapper, UsersDAO usersDAO) {
        this.userMapper = userMapper;
        this.usersDAO = usersDAO;
    }

    @Override
    public List<DomainUser> getAllUsers() {
        return userMapper.transformToUsers(
                usersDAO.getAllUsers()
        );
    }

    @Override
    public DomainUser getUser(String userId) {
        return userMapper.transform(
                usersDAO.getUserById(userId)
        );
    }

    @Override
    public DomainUser getEmptyUser() {
        return new DomainUser(
                UUID.randomUUID().toString(),
                "",
                ""
//                ""
        );
    }

    @Override
    public DomainUser getUserByLogin(String login) {
        return userMapper.transform(
                usersDAO.getUserByLogin(login)
        );
    }

    @Override
    public void saveUser(DomainUser user) {
        usersDAO.putUser(
                userMapper.transform(user)
        );
    }

    @Override
    public void deleteUser(String userId) {
        usersDAO.deleteUserById(userId);
    }

    //TODO
    @Override
    public String getCurrentUserId() {
        var login = SecurityContextHolder.getContext().getAuthentication().getName();
        var s = SecurityContextHolder.getContext().getAuthentication().getCredentials();
        return getUserByLogin(login).getId();
    }
}
