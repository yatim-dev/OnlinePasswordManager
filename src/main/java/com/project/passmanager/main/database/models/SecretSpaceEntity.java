package com.project.passmanager.main.database.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Модель пространства для секретов для database слоя
 * */
@Data
@AllArgsConstructor
public class SecretSpaceEntity {
    private String id;
    private String name;
}
