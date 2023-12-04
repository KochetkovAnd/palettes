package com.kochetkov.palettes.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tag")
@Data
public class Tag {

    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
