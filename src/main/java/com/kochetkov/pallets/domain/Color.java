package com.kochetkov.pallets.domain;

import com.kochetkov.pallets.domain.enums.BaseColor;
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
    private String hex;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "base_color")
    private BaseColor baseColor;

    @Column(name = "description")
    private String description;
}