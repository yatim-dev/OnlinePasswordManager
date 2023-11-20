package com.project.passmanager.main.database.core;

import com.project.passmanager.main.database.models.UserEntity;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.TransactionException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UsersDAO {

    SessionFactory sessionFactory;

    public List<UserEntity> getAllUsers() throws TransactionException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            var users = session
                    .createQuery("FROM UserEntity", UserEntity.class)
                    .getResultList();
            session.getTransaction().commit();
            return users;
        }
    }

    public UserEntity getUserById(String userId) throws TransactionException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            var user = session.createQuery(
                    "FROM UserEntity WHERE id = :userId",
                    UserEntity.class
            )
                    .setParameter("userId", userId)
                    .uniqueResult();
            session.getTransaction().commit();
            return user;
        }
    }

    public UserEntity getUserByLogin(String login) throws TransactionException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            var user = session.createQuery(
                    "SELECT u FROM UserEntity u WHERE u.login = :login",
                    UserEntity.class
            )
                    .setParameter("login", login)
                    .uniqueResult();
            session.getTransaction().commit();
            return user;
        }
    }

    public void putUser(UserEntity user) throws TransactionException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
        }
    }

    //TODO: id сбивается
    public void updateUser(UserEntity user) throws TransactionException {
        deleteUser(user);
        putUser(user);
        //session.refresh()
    }

    public void deleteUser(UserEntity user) throws TransactionException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.remove(user);
            session.getTransaction().commit();
        }
    }
}
