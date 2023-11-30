package com.kochetkov.palettes.mapper;

import com.kochetkov.palettes.DTO.TagDTO;
import com.kochetkov.palettes.domain.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TagMapper {
    TagMapper TAG_MAPPER = Mappers.getMapper(TagMapper.class);

    Tag toEntity(TagDTO tagDTO);
    TagDTO toDTO(Tag tag);
    List<Tag> allToEntity(List<TagDTO> tagDTOList);
    List<TagDTO> allToDTO(List<Tag> tagList);
}
