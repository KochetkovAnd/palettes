package com.kochetkov.pallets.mapper;

import com.kochetkov.pallets.DTO.ColorDTO;
import com.kochetkov.pallets.domain.Color;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ColorMapper {
    ColorMapper COLOR_MAPPER = Mappers.getMapper(ColorMapper.class);
    @Mapping(target = "password", ignore = true)
    Color toEntity(ColorDTO colorDTO);
    ColorDTO toDTO(Color color);
    List<Color> allToEntity(List<ColorDTO> colorDTOList);
    List<ColorDTO> allToDTO(List<Color> colorList);
}
