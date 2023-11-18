package com.project.passmanager.main.database.core;

import com.project.passmanager.main.database.models.SecretSpaceEntity;
import com.project.passmanager.main.database.models.UserEntity;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.TransactionException;

import java.util.List;

@AllArgsConstructor
public class SecretSpaceDAO {
    SessionFactory sessionFactory;

    public void putSecretSpaceByUser(UserEntity user, SecretSpaceEntity secretSpace) throws TransactionException {
        try (Session session = sessionFactory.getCurrentSession()) {
            secretSpace.setUser(user);
            session.beginTransaction();
            session.persist(secretSpace);
            session.getTransaction().commit();
        }
    }

    public List<SecretSpaceEntity> getSecretSpacesByUser(UserEntity user) throws TransactionException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            var secretSpaceEntities = session.createQuery(
                    "SELECT ss FROM SecretSpaceEntity ss WHERE ss.user.id = :user_id",
                    SecretSpaceEntity.class)
                    .setParameter("user_id", user.getId())
                    .getResultList();
            session.getTransaction().commit();
            return secretSpaceEntities;
        }
    }

    public void deleteSecretSpaceById(UserEntity user, String secretSpaceId) throws TransactionException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            var secretSpace = session.find(SecretSpaceEntity.class, secretSpaceId);
            if (secretSpace != null && secretSpace.getUser().equals(user))
                session.remove(secretSpace);
            session.getTransaction().commit();
        }
    }

}
