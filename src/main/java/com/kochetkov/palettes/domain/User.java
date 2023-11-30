package com.kochetkov.palettes.domain;

import com.kochetkov.palettes.domain.enums.Role;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "users") // Тк user занят в postgre
@Data
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
