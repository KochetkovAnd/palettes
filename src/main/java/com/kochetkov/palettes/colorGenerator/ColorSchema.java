package com.kochetkov.palettes.colorGenerator;

import com.kochetkov.palettes.DTO.ColorInPaletteDTO;

import java.util.List;

public interface ColorSchema {
    public List<ColorInPaletteDTO> insertMissing(List<ColorInPaletteDTO> colorInPaletteDTOList);
}
