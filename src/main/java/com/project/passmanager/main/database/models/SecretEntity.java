package com.project.passmanager.main.database.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Модель секркета для database слоя
 * */
@Data
@AllArgsConstructor
public class SecretEntity {
    private String id;
    private String secretSpaceId;
    private String name;
    private String login;
    private String password;
    private String note;
}
