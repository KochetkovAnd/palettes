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

    // TODO узнать про @MapsId  и можно ли от нее избавится
    @JsonIgnore
    @ManyToOne
    @MapsId("paletteId")
    @JoinColumn(name = "palette_id")
    private Palette palette;

//    @JsonIgnore
    @ManyToOne
    @MapsId("colorId")
    @JoinColumn(name = "color_id")
    private Color color;

    @Column(name = "color_role")
    private String colorRole;
}
