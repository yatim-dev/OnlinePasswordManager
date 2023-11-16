package com.project.passmanager.main.database.core;

import com.project.passmanager.main.database.models.SecretSpaceEntity;
import com.project.passmanager.main.database.models.UserEntity;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.TransactionException;

@AllArgsConstructor
public class SecretSpaceDAO {
    SessionFactory sessionFactory;

    public void saveSecretSpaceByUser(UserEntity user, SecretSpaceEntity secretSpace) throws TransactionException {
        try (Session session = sessionFactory.getCurrentSession()) {
            secretSpace.setUser(user);
            session.beginTransaction();
            session.persist(secretSpace);
            session.getTransaction().commit();
        }
    }



}
