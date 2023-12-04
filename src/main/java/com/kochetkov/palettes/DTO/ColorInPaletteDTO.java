package com.kochetkov.palettes.DTO;

import com.kochetkov.palettes.domain.Color;
import com.kochetkov.palettes.domain.Palette;
import lombok.Data;

@Data
public class ColorInPaletteDTO {
    private long id;
    private String hex;
    private String colorRole;
}
