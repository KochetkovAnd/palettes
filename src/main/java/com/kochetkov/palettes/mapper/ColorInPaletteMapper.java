package com.kochetkov.palettes.mapper;

import com.kochetkov.palettes.DTO.ColorInPaletteDTO;
import com.kochetkov.palettes.domain.ColorInPalette;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ColorInPaletteMapper {
    ColorInPaletteMapper COLOR_IN_PALETTE_MAPPER = Mappers.getMapper(ColorInPaletteMapper.class);

    ColorInPalette toEntity(ColorInPaletteDTO colorInPaletteDTO);
    ColorInPaletteDTO toDTO(ColorInPalette colorInPalette);
    List<ColorInPalette> allToEntity(List<ColorInPaletteDTO> colorInPaletteDTOList);
    List<ColorInPaletteDTO> allToDTO(List<ColorInPalette> colorInPaletteList);
}
