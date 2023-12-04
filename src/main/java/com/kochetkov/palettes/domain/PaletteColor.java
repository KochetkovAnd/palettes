package com.kochetkov.palettes.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kochetkov.palettes.domain.keys.PaletteColorKey;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "palette_color")
public class PaletteColor {

    @EmbeddedId
    private PaletteColorKey id;

    @JsonIgnore
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
