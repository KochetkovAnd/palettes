package com.kochetkov.pallets.domain;

import com.kochetkov.pallets.domain.enums.Role;
import jakarta.persistence.*;


@Entity
@Table(name = "users") // Тк user занят в postgre
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Role role;

}
