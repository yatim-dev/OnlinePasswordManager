package com.project.passmanager.main.database.models;

import jakarta.persistence.*;
import lombok.*;

/**
 * Модель секркета для database слоя
 * */
@Getter
@Setter
@Entity
@Table(name = "secrets")
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class SecretEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @ManyToOne
    @JoinColumn(name = "secret_space_id", referencedColumnName = "id")
    private SecretSpaceEntity secretSpace;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "note")
    private String note;

    @Column(name = "url")
    private String url;

    public SecretEntity(SecretSpaceEntity secretSpace, String name, String login, String password, String note, String url) {
        this.secretSpace = secretSpace;
        this.name = name;
        this.login = login;
        this.password = password;
        this.note = note;
        this.url = url;
    }
}
