package com.project.passmanager.main.network.services;

import com.project.passmanager.main.algorithms.AES.EncryptConfig;
import com.project.passmanager.main.domain.models.Secret;
import com.project.passmanager.main.domain.models.SecretSpace;
import com.project.passmanager.main.domain.repositories.ISecretRepository;
import com.project.passmanager.main.domain.repositories.ISpaceSecretsRepository;
import com.project.passmanager.main.domain.repositories.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ChangeSaltService {
    private final IUserRepository userRepository;
    private final ISecretRepository secretRepository;
    private final ISpaceSecretsRepository spaceSecretsRepository;
    public void changeSalt(){
        var map = new HashMap<SecretSpace, List<Secret>>();
        var user = userRepository.getUserByLogin(EncryptConfig.username);
        var secretSpaces = spaceSecretsRepository.getSecretSpaces(user.getId());
        for(var secretSpace: secretSpaces) {
            var openSecrets = secretRepository.getSecretsBySecretSpaceId(secretSpace.getId());
            map.put(secretSpace, openSecrets);
        }
        for(var secretSpace: secretSpaces) {
            secretRepository.deleteSecretsInSecretSpace(secretSpace.getId());
        }
        EncryptConfig.saltNum = String.valueOf(new Random().nextInt());
        user.setSaltNum(EncryptConfig.saltNum);
        userRepository.updateUserSaltNum(user.getId(), user.getSaltNum());
        for (var secrets: map.entrySet()) {
            for (var secret: secrets.getValue()) {
                secretRepository.saveSecret(secret);
            }
        }
    }
}
