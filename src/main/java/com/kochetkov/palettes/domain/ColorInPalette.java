package com.kochetkov.palettes.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "palette_color")
public class ColorInPalette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "hex")
    private String hex;

    @Column(name = "color_role")
    private String colorRole;
}
