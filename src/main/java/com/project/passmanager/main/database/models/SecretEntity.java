package com.project.passmanager.main.database.models;

import lombok.AllArgsConstructor;
import lombok.Data;

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
