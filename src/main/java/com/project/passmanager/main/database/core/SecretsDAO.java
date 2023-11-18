package com.project.passmanager.main.database.core;

import com.project.passmanager.main.database.models.SecretEntity;
import com.project.passmanager.main.database.models.SecretSpaceEntity;
import lombok.AllArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.TransactionException;

import java.util.List;

@AllArgsConstructor
public class SecretsDAO {
    SessionFactory sessionFactory;

    public List<SecretEntity> getSecretsBySecretSpace(SecretSpaceEntity secretSpace) throws TransactionException{
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            var secrets = session.createQuery(
                            "SELECT secret FROM SecretEntity secret WHERE secret.secretSpace.id = :secretSpace_id",
                            SecretEntity.class)
                    .setParameter("secretSpace_id", secretSpace.getId())
                    .getResultList();
            session.getTransaction().commit();
            return secrets;
        }

    }

    public SecretEntity getSecretById(Long secretId) throws TransactionException{
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            var secret = session.find(SecretEntity.class, secretId.toString());
            session.getTransaction().commit();
            if (secret != null)
                return secret;
            else
                throw new TransactionException("");
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void putSecret(SecretSpaceEntity secretSpace, SecretEntity secret) throws TransactionException {
        try (Session session = sessionFactory.getCurrentSession()) {

            secret.setSecretSpace(secretSpace);
            session.beginTransaction();
            session.persist(secret);
            session.getTransaction().commit();
        }
    }

    public void deleteSecretById(Long secretId) throws TransactionException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            var secret = session.find(SecretEntity.class, secretId.toString());
            if (secret != null)
                session.remove(secret);
            session.getTransaction().commit();
        }
    }

    public void deleteAllSecretsBySecretSpace(SecretSpaceEntity secretSpace) throws TransactionException {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            var secrets = session.createQuery(
                            "SELECT secret FROM SecretEntity secret WHERE secret.secretSpace.id = :secretSpace_id",
                            SecretEntity.class)
                    .setParameter("secretSpace_id", secretSpace.getId())
                    .getResultList();

            if (secrets != null)
                for (var secret: secrets) {
                    session.remove(secret);
                }

            session.getTransaction().commit();
        }
    }

}
