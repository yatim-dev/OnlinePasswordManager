package com.project.passmanager.main.database.core;

import com.project.passmanager.main.database.models.SecretEntity;

import java.util.*;

public class InMemoryCacheSecrets {
    private static final Map<String, SecretEntity> secrets = new HashMap<>();

    public static List<SecretEntity> getSecrets() {
        return new ArrayList<>(secrets.values());
    }

    public static List<SecretEntity> getSecretsBySecretSpaceId(String secretSpaceId) {
        return secrets
                .values()
                .stream()
                .filter(secretEntity -> secretEntity.getSecretSpaceId().equals(secretSpaceId))
                .toList();
    }

    public static SecretEntity getSecretById(String id) {
        return secrets.get(id);
    }

    public static SecretEntity getEmptySecret(String secretSpaceId) {
        return new SecretEntity(
                UUID.randomUUID().toString(),
                secretSpaceId,
                "",
                "",
                "",
                ""
        );
    }

    public static void putSecret(SecretEntity secret) {
        secrets.put(secret.getId(), secret);
    }

    public static void deleteSecret(String id) {
        secrets.remove(id);
        System.out.println("dssd");
    }

    public static void deleteAllSecretsBySecretSpaceId(String secretSpaceId) {
        for (SecretEntity secret : getSecrets()) {
            if (secret.getSecretSpaceId().equals(secretSpaceId)) {
                deleteSecret(secret.getId());
            }
        }
    }
}
