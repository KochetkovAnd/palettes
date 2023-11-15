package com.kochetkov.pallets.mapper;

import com.kochetkov.pallets.DTO.CollectionDTO;
import com.kochetkov.pallets.domain.Collection;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface CollectionMapper {
    CollectionMapper COLLECTION_MAPPER = Mappers.getMapper(CollectionMapper.class);
    @Mapping(target = "password", ignore = true)
    Collection toEntity(CollectionDTO collectionDTO);
    CollectionDTO toDTO(Collection collection);
    List<Collection> allToEntity(List<CollectionDTO> collectionDTOList);
    List<CollectionDTO> allToDTO(List<Collection> collectionList);
}
