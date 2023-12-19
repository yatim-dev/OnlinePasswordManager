package com.project.passmanager.main.network.services;

import com.project.passmanager.main.algorithms.AES.EncryptConfig;
import com.project.passmanager.main.domain.models.DomainUser;
import com.project.passmanager.main.domain.models.Role;
import com.project.passmanager.main.domain.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Класс реализует интерфейс UserDetailsService (этот интерфейс используется для получения данных пользователя)
 */
@RequiredArgsConstructor
@Component
public class UserRegistrationService implements UserDetailsService {
    private final IUserRepository userRepository;
    /**
     * Загрузка пользователя по его имени
     *
     * @param username имя пользователя, идентифицирующее пользователя, данные которого требуются
     * @return возвращает найденного пользователя
     * @throws UsernameNotFoundException ошибка, если пользователь с таким именем не найден
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Collection<GrantedAuthority> role = new ArrayList<>();
        role.add(new SimpleGrantedAuthority(("ROLE_" + Role.USER)));
        DomainUser domainUser;

        try {
            domainUser = userRepository.getUserByLogin(username);
            EncryptConfig.saltNum = domainUser.getSaltNum();
            EncryptConfig.key = domainUser.getHashPassword()
                    .substring(domainUser.getHashPassword().length() / 5, domainUser.getHashPassword().length() - 1)
                    + domainUser.getSaltNum();
        } catch (Exception exception) {
            throw new UsernameNotFoundException("custom message user not found");
        }

        return new User(
                domainUser.getLogin(),
                domainUser.getHashPassword(),
                role
        );
    }

    /**
     * Метод для добавления пользователя в базу данных
     *
     * @param domainUser пользователь
     * @throws Exception ошибка, если пользователь с таким именем уже существует в базе данных
     */
    public void addUser(DomainUser domainUser) throws Exception {
        DomainUser userRegistrationFromDb;

        try {
            userRegistrationFromDb = userRepository.getUserByLogin(domainUser.getLogin());
        } catch (Exception exception) {
            userRegistrationFromDb = null;
        }

        if (userRegistrationFromDb != null) {
            throw new Exception("domainUser exist");
        }
        
        userRepository.saveUser(domainUser);
    }
}
