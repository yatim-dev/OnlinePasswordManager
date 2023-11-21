package com.project.passmanager.main.database;

import com.project.passmanager.main.database.core.SecretSpaceDAO;
import com.project.passmanager.main.database.core.SecretsDAO;
import com.project.passmanager.main.database.core.UsersDAO;
import com.project.passmanager.main.database.mappers.SecretMapper;
import com.project.passmanager.main.database.mappers.SecretSpaceMapper;
import com.project.passmanager.main.database.mappers.UserMapper;
import com.project.passmanager.main.database.models.SecretEntity;
import com.project.passmanager.main.database.models.SecretSpaceEntity;
import com.project.passmanager.main.database.models.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class Config {
    @Bean
    public SessionFactory sessionFactory(){
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserEntity.class)
                .addAnnotatedClass(SecretEntity.class)
                .addAnnotatedClass(SecretSpaceEntity.class)
                .buildSessionFactory();
    }

    @Bean
    public SecretMapper secretMapper(){
        return new SecretMapper();
    }
    @Bean
    public SecretsDAO secretsDAO(){
        return new SecretsDAO();
    }
    @Bean
    public SecretSpaceMapper secretSpaceMapper() {return new SecretSpaceMapper();}
    @Bean
    public SecretSpaceDAO secretSpaceDAO() {return new SecretSpaceDAO();}
    @Bean
    public UserMapper userMapper() {return new UserMapper();}
    @Bean
    public UsersDAO usersDAO() {return new UsersDAO();}
}
