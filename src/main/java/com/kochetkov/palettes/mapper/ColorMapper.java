package com.kochetkov.palettes.mapper;

import com.kochetkov.palettes.DTO.ColorDTO;
import com.kochetkov.palettes.domain.Color;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ColorMapper {
    ColorMapper COLOR_MAPPER = Mappers.getMapper(ColorMapper.class);

    Color toEntity(ColorDTO colorDTO);
    ColorDTO toDTO(Color color);
    List<Color> allToEntity(List<ColorDTO> colorDTOList);
    List<ColorDTO> allToDTO(List<Color> colorList);
}
