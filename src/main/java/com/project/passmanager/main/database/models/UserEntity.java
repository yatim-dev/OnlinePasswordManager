package com.project.passmanager.main.database.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "users")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "id")
    private String id = UUID.randomUUID().toString();

    @Column(name = "login", unique = true, nullable = false)
    private String login;

    @Column(name = "hashpassword")
    private String hashPassword;

//    @Column(name="salt_num")
//    private String saltNum;

    public UserEntity(String login, String hashPassword) {
        this.login = login;
        this.hashPassword = hashPassword;
    }
}
