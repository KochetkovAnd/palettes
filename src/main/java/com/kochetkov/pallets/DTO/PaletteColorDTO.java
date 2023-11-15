package com.kochetkov.pallets.DTO;

import com.kochetkov.pallets.domain.Color;
import com.kochetkov.pallets.domain.Palette;
import com.kochetkov.pallets.domain.keys.PaletteColorKey;
import lombok.Data;

@Data
public class PaletteColorDTO {
    private PaletteColorKey id;
    private Palette palette;
    private Color color;
    private String colorRole;
}
