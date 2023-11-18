package com.project.passmanager.main.database.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "users")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "hashpassword")
    private String hashPassword;

    public UserEntity(String login, String hashPassword) {
        this.login = login;
        this.hashPassword = hashPassword;
    }
}
