package com.kochetkov.palettes.mapper;

import com.kochetkov.palettes.DTO.PaletteDTO;
import com.kochetkov.palettes.domain.Palette;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PaletteMapper {
    PaletteMapper PALETTE_MAPPER = Mappers.getMapper(PaletteMapper.class);

    Palette toEntity(PaletteDTO paletteDTO);
    PaletteDTO toDTO(Palette palette);
    List<Palette> allToEntity(List<PaletteDTO> paletteDTOList);
    List<PaletteDTO> allToDTO(List<Palette> paletteList);
}
