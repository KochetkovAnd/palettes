package com.kochetkov.palettes.service;

import com.kochetkov.palettes.DTO.CollectionDTO;
import com.kochetkov.palettes.domain.Collection;
import com.kochetkov.palettes.exeption.AlreadyExistException;
import com.kochetkov.palettes.exeption.ResourceNotFoundException;
import com.kochetkov.palettes.mapper.CollectionMapper;
import com.kochetkov.palettes.repository.CollectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CollectionService {

    private final CollectionRepository collectionRepository;

    private List<CollectionDTO> getAll() {
        return allToDTO(collectionRepository.findAll());
    }

    private CollectionDTO getById(Long id) {
        Optional<Collection> collection = collectionRepository.findById(id);
        if (collection.isPresent()) {
            return toDTO(collection.get());
        }
        throw new ResourceNotFoundException("Collection with id = "+ id + " not found", "");
    }

    private CollectionDTO create(CollectionDTO collectionDTO) {
        if (!collectionRepository.findByName(collectionDTO.getName()).isPresent()) {
            collectionRepository.save(toEntity(collectionDTO));
            return toDTO(collectionRepository.findByName(collectionDTO.getName()).get());
        }
        throw new AlreadyExistException("Collection with name = " + collectionDTO.getName() + " already exist", "");
    }

    private CollectionDTO update(CollectionDTO collectionDTO) {
        if (!collectionRepository.findById(collectionDTO.getId()).isPresent()) {
            collectionRepository.save(toEntity(collectionDTO));
            return toDTO(collectionRepository.getById(collectionDTO.getId()));
        }
        throw new ResourceNotFoundException("Collection with id = "+ collectionDTO.getId() + " not found", "");
    }

    public boolean deleteById(Long id) {
        Optional<Collection> collection = collectionRepository.findById(id);
        if (!collection.isPresent()) {
            return false;
        }
        collectionRepository.delete(collection.get());
        return true;
    }

    //TODO Возможно тут надо отлавливать если пытаешься удалить связанные обьекты

    private Collection toEntity(CollectionDTO collectionDTO) {
        return CollectionMapper.COLLECTION_MAPPER.toEntity(collectionDTO);
    }
    private CollectionDTO toDTO(Collection collection) {
        return CollectionMapper.COLLECTION_MAPPER.toDTO(collection);
    }
    private List<Collection> allToEntity(List<CollectionDTO> collectionDTOList) {
        return CollectionMapper.COLLECTION_MAPPER.allToEntity(collectionDTOList);
    }
    private List<CollectionDTO> allToDTO(List<Collection> collectionList) {
        return CollectionMapper.COLLECTION_MAPPER.allToDTO(collectionList);
    }
}
