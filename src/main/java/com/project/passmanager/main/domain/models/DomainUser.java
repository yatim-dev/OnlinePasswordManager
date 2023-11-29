package com.project.passmanager.main.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Модель пользователя для domain слоя
 * */
@Data
@AllArgsConstructor
public class DomainUser {
    private String id;
    private String login;
    private String hashPassword;
//    private String saltNum;
}
