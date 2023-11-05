package com.project.passmanager.main.database.core;

import com.project.passmanager.main.database.models.SecretSpaceEntity;

import java.util.*;

public class InMemoryCacheSecretSpace {

    private static final SecretSpaceEntity defaultSecretSpace = new SecretSpaceEntity(
            UUID.randomUUID().toString(),
            "defaultSpace"
    );
    private static final Map<String, SecretSpaceEntity> spaces = new HashMap<>();
    static {
        spaces.put(defaultSecretSpace.getId(), defaultSecretSpace);
    }

    public static String getIdDefaultSecretSpace() {
        return defaultSecretSpace.getId();
    }

    public static List<SecretSpaceEntity> getSecretSpaces() {
        return new ArrayList<>(spaces.values());
    }

    public static void saveSecretSpace(SecretSpaceEntity secretSpace) {
        spaces.put(secretSpace.getId(), secretSpace);
    }

    public static void deleteSecretSpace(String secretSpaceId) {
        InMemoryCacheSecrets.deleteAllSecretsBySecretSpaceId(secretSpaceId);
        spaces.remove(secretSpaceId);
    }
}
