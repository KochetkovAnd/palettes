package com.kochetkov.pallets.domain;

import com.kochetkov.pallets.domain.keys.PaletteColorKey;

import javax.persistence.*;

@Entity
@Table(name = "palette_color")
public class PaletteColor {

    @EmbeddedId
    private PaletteColorKey id;

    @Column(name = "color_role")
    private String colorRole;
}
