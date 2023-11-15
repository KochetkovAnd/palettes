package com.kochetkov.pallets.mapper;

import com.kochetkov.pallets.DTO.TagDTO;
import com.kochetkov.pallets.domain.Tag;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TagMapper {
    TagMapper TAG_MAPPER = Mappers.getMapper(TagMapper.class);
    @Mapping(target = "password", ignore = true)
    Tag toEntity(TagDTO tagDTO);
    TagDTO toDTO(Tag tag);
    List<Tag> allToEntity(List<TagDTO> tagDTOList);
    List<TagDTO> allToDTO(List<Tag> tagList);
}
