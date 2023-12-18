package com.project.passmanager.main.database.repositories;

import com.project.passmanager.main.EncryptConfig;
import com.project.passmanager.main.algorithms.AES.AESEncryption;
import com.project.passmanager.main.algorithms.AES.SaltReader;
import com.project.passmanager.main.database.core.SecretsDAO;
import com.project.passmanager.main.database.mappers.SecretMapper;
import com.project.passmanager.main.domain.models.Secret;
import com.project.passmanager.main.domain.repositories.ISecretRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SecretRepositoryImpl implements ISecretRepository {
    SecretMapper secretMapper;
    SecretsDAO secretsDAO;
    AESEncryption aesEncryption;
    SaltReader saltReader;

    @Autowired
    public SecretRepositoryImpl(SecretMapper secretMapper, SecretsDAO secretsDAO, AESEncryption aesEncryption, SaltReader saltReader) {
        this.secretMapper = secretMapper;
        this.secretsDAO = secretsDAO;
        this.aesEncryption = aesEncryption;
        this.saltReader = saltReader;
    }
    
    private Secret transformDecrypt(Secret secret){
        String key;
        String salt;
        try {
            key = EncryptConfig.key;
            salt = saltReader.getSalt(EncryptConfig.saltNum);
            secret.setName(aesEncryption.decrypt(key, salt, secret.getName()));
            secret.setLogin(aesEncryption.decrypt(key, salt, secret.getLogin()));
            secret.setPassword(aesEncryption.decrypt(key, salt, secret.getPassword()));
            secret.setNote(aesEncryption.decrypt(key, salt, secret.getNote()));
            secret.setUrl(aesEncryption.decrypt(key, salt, secret.getUrl()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return secret;
    }

    private Secret transformEncrypt(Secret secret) {
        String key;
        String salt;
        try {
            key = EncryptConfig.key;
            salt = saltReader.getSalt(EncryptConfig.saltNum);
            secret.setName(aesEncryption.encrypt(key, salt, secret.getName()));
            secret.setLogin(aesEncryption.encrypt(key, salt, secret.getLogin()));
            secret.setPassword(aesEncryption.encrypt(key, salt, secret.getPassword()));
            secret.setNote(aesEncryption.encrypt(key, salt, secret.getNote()));
            secret.setUrl(aesEncryption.encrypt(key, salt, secret.getUrl()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return secret;
    }

    @Override
    public List<Secret> getSecrets(String secretSpaceId) {
        var secrets = secretMapper.transformToSecrets(
                secretsDAO.getSecretsBySecretSpaceId(secretSpaceId)
        );
        return secrets
                .stream()
                .map(this::transformDecrypt)
                .toList();
    }

    @Override
    public List<Secret> getSecretsBySecretSpaceId(String secretSpaceId) {
        var secrets = secretMapper.transformToSecrets(
                secretsDAO.getSecretsBySecretSpaceId(secretSpaceId)
        );
        return secrets.stream().map(this::transformDecrypt).toList();
    }

    @Override
    public Secret getSecretById(String secretId) {
        return transformDecrypt(secretMapper.transform(secretsDAO.getSecretById(secretId)));
    }

    @Override
    public Secret getTempSecret(String secretSpaceId) {
        return new Secret(UUID.randomUUID().toString(), secretSpaceId, "", "", "", "", "");
    }

    @Override
    public void saveSecret(Secret secret) {
       var encryptSecret = transformEncrypt(secret);
        secretsDAO.putSecret(
                secretMapper.transform(encryptSecret)
        );
    }

    @Override
    public void deleteSecret(String secretId) {
        secretsDAO.deleteSecretById(secretId);
    }

    @Override
    public void deleteSecretsInSecretSpace(String secretSpaceId) {
        secretsDAO.deleteAllSecretsBySecretSpace(secretSpaceId);
    }
}
