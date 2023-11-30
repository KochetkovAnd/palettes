package com.kochetkov.palettes.mapper;

import com.kochetkov.palettes.DTO.CollectionDTO;
import com.kochetkov.palettes.domain.Collection;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CollectionMapper {
    CollectionMapper COLLECTION_MAPPER = Mappers.getMapper(CollectionMapper.class);

    Collection toEntity(CollectionDTO collectionDTO);
    CollectionDTO toDTO(Collection collection);
    List<Collection> allToEntity(List<CollectionDTO> collectionDTOList);
    List<CollectionDTO> allToDTO(List<Collection> collectionList);
}
