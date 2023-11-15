package com.kochetkov.pallets.mapper;

import com.kochetkov.pallets.DTO.PaletteDTO;
import com.kochetkov.pallets.domain.Palette;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PaletteMapper {
    PaletteMapper PALETTE_MAPPER = Mappers.getMapper(PaletteMapper.class);
    @Mapping(target = "password", ignore = true)
    Palette toEntity(PaletteDTO paletteDTO);
    PaletteDTO toDTO(Palette palette);
    List<Palette> allToEntity(List<PaletteDTO> paletteDTOList);
    List<PaletteDTO> allToDTO(List<Palette> paletteList);
}
