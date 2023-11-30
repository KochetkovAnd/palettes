package com.kochetkov.palettes.mapper;

import com.kochetkov.palettes.DTO.PaletteColorDTO;
import com.kochetkov.palettes.domain.PaletteColor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface PaletteColorMapper {
    PaletteColorMapper PALETTE_COLOR_MAPPER = Mappers.getMapper(PaletteColorMapper.class);

    PaletteColor toEntity(PaletteColorDTO paletteColorDTO);
    PaletteColorDTO toDTO(PaletteColor paletteColor);
    List<PaletteColor> allToEntity(List<PaletteColorDTO> paletteColorDTOList);
    List<PaletteColorDTO> allToDTO(List<PaletteColor> paletteColorList);
}
