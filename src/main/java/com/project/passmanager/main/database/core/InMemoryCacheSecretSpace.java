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
        String id2 = UUID.randomUUID().toString();
        String id3 = UUID.randomUUID().toString();

        spaces.put(defaultSecretSpace.getId(), defaultSecretSpace);
        spaces.put(id2, new SecretSpaceEntity(id2, "space2"));
        spaces.put(id3, new SecretSpaceEntity(id3, "space3"));
    }

    public static String getIdDefaultSecretSpace() {
        return defaultSecretSpace.getId();
    }

    public static List<SecretSpaceEntity> getSecretSpaces() {
        return new ArrayList<>(spaces.values());
    }
}
