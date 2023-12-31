package com.kochetkov.palettes.domain;

import com.kochetkov.palettes.domain.enums.BaseColor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "color")
@Data
public class Color {

    @Id
    @Column(name = "hex")
    private String hex;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "base_color")
    private BaseColor baseColor;

    @Column(name = "description")
    private String description;
}