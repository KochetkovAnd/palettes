package com.kochetkov.pallets.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "color")
@Data
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "hex")
    private String name;

    @Column(name = "description")
    private String description;
}