package com.project.passmanager.main.database.core;

import com.project.passmanager.main.database.mappers.SecretMapper;
import com.project.passmanager.main.domain.models.SecretSpace;

import java.util.*;

public class InMemoryCacheSecretSpace {

    private static final SecretSpace defaultSecretSpace = new SecretSpace(
            UUID.randomUUID().toString(),
            "defaultSpace",
            new ArrayList<>()
    );
    private static final Map<String, SecretSpace> spaces = new HashMap<>();
    static {
        String id2 = UUID.randomUUID().toString();
        String id3 = UUID.randomUUID().toString();

        spaces.put(defaultSecretSpace.getId(), defaultSecretSpace);
        spaces.put(id2, new SecretSpace(id2, "space2", new ArrayList<>()));
        spaces.put(id3, new SecretSpace(id3, "space3", new ArrayList<>()));
    }

    public static String getIdDefaultSecretSpace() {
        return defaultSecretSpace.getId();
    }

    public static List<SecretSpace> getSecretSpaces() {
        return new ArrayList<>(spaces.values());
    }

    public static SecretSpace getSecretSpaceById(String id) {
        var space = spaces.get(id);
        space.setSecrets(SecretMapper.transformToSecrets(InMemoryCacheSecrets.getSecretsBySecretSpaceId(id)));
        return space;
    }
}
