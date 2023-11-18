package com.project.passmanager.main.database.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

/**
 * Модель пространства для секретов для database слоя
 * */
@Getter
@Setter
@Entity
@Table(name = "secret_spaces")
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class SecretSpaceEntity {
    @Id
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity user;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    public SecretSpaceEntity(UserEntity user, String name) {
        this.user = user;
        this.name = name;
    }
}
