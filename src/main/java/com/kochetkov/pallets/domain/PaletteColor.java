package com.kochetkov.pallets.domain;

import com.kochetkov.pallets.domain.keys.PaletteColorKey;

import javax.persistence.*;

@Entity
@Table(name = "palette_color")
public class PaletteColor {

    @EmbeddedId
    private PaletteColorKey id;

    @ManyToOne
    @MapsId("paletteId")
    @JoinColumn(name = "palette_id")
    private Palette palette;

    @ManyToOne
    @MapsId("colorId")
    @JoinColumn(name = "color_id")
    private Color color;

    @Column(name = "color_role")
    private String colorRole;
}
