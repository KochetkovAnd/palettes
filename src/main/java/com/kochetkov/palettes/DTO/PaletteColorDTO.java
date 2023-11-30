package com.kochetkov.palettes.DTO;

import com.kochetkov.palettes.domain.Color;
import com.kochetkov.palettes.domain.Palette;
import com.kochetkov.palettes.domain.keys.PaletteColorKey;
import lombok.Data;

@Data
public class PaletteColorDTO {
    private PaletteColorKey id;
    private Color color;
    private String colorRole;
}
