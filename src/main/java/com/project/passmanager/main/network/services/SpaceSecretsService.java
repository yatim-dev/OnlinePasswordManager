package com.project.passmanager.main.network.services;

import com.project.passmanager.main.domain.Secret;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class SpaceSecretsService {

    private final Map<String, Secret> secrets = new HashMap<>();
    {
        String id1 = UUID.randomUUID().toString();
        String id2 = UUID.randomUUID().toString();
        String id3 = UUID.randomUUID().toString();

        secrets.put(id1, new Secret(id1, "password for email"));
        secrets.put(id2, new Secret(id2, "password for games"));
        secrets.put(id3, new Secret(id3, "password for box"));
    }

    public Collection<Secret> getSecrets() {
        return secrets.values();
    }

    public Secret getSecretById(String id) {
        return secrets.get(id);
    }

    public Secret getEmptySecret() {
        return new Secret(UUID.randomUUID().toString(), "");
    }

    public void putSecret(Secret secret) { secrets.put(secret.getId(), secret); }

    public void deleteSecret(String id) { secrets.remove(id); }
}
