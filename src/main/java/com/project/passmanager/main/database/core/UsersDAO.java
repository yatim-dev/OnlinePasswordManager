package com.project.passmanager.main.database.core;

import com.project.passmanager.main.database.models.UserEntity;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.TransactionException;

import java.util.List;

@AllArgsConstructor
public class UsersDAO {

    SessionFactory sessionFactory;

    public List<UserEntity> getAllUsers() throws TransactionException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Query<UserEntity> query = session.createQuery("FROM UserEntity", UserEntity.class);
            List<UserEntity> users = query.getResultList();
            session.getTransaction().commit();
            return users;
        }
    }

    public UserEntity getUserById(Long userId) throws TransactionException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Query<UserEntity> query = session.createQuery("FROM UserEntity WHERE id = :userId", UserEntity.class);
            query.setParameter("userId", userId);
            List<UserEntity> users = query.getResultList();
            session.getTransaction().commit();
            return users.get(0);
        }
    }

    public UserEntity getUserByLogin(String login) throws TransactionException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Query<UserEntity> query = session.createQuery("SELECT u FROM UserEntity u WHERE u.login = :login", UserEntity.class);
            query.setParameter("login", login);
            List<UserEntity> users = query.getResultList();
            session.getTransaction().commit();
            return users.get(0);
        }
    }

    public void putUser(UserEntity user) throws TransactionException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.persist(user);
            session.getTransaction().commit();
        }
    }

    public void updateUser(UserEntity user) throws TransactionException {
        deleteUser(user);
        putUser(user);
    }

    public void deleteUser(UserEntity user) throws TransactionException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.remove(user);
            session.getTransaction().commit();
        }
    }
}
