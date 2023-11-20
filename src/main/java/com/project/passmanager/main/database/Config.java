package com.project.passmanager.main.database;

import com.project.passmanager.main.database.models.SecretEntity;
import com.project.passmanager.main.database.models.SecretSpaceEntity;
import com.project.passmanager.main.database.models.UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class Config {
    public static SessionFactory sessionFactory = new org.hibernate.cfg.Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(UserEntity.class)
            .addAnnotatedClass(SecretEntity.class)
            .addAnnotatedClass(SecretSpaceEntity.class)
            .buildSessionFactory();
}
