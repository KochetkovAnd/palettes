package com.kochetkov.palettes.service;

import com.kochetkov.palettes.DTO.TagDTO;
import com.kochetkov.palettes.domain.Tag;
import com.kochetkov.palettes.exeption.AlreadyExistException;
import com.kochetkov.palettes.exeption.ResourceNotFoundException;
import com.kochetkov.palettes.mapper.TagMapper;
import com.kochetkov.palettes.repository.TagRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagRepository tagRepository;

    private List<TagDTO> getAll() {
        return allToDTO(tagRepository.findAll());
    }



    private TagDTO create(TagDTO tagDTO) {
        if (!tagRepository.findByName(tagDTO.getName()).isPresent()) {
            tagRepository.save(toEntity(tagDTO));
            return toDTO(tagRepository.findByName(tagDTO.getName()).get());
        }
        throw new AlreadyExistException("Tag with name = " + tagDTO.getName() + " already exist", "");
    }

    public boolean deleteById(Long id) {
        Optional<Tag> tag = tagRepository.findById(id);
        if (!tag.isPresent()) {
            return false;
        }
        tagRepository.delete(tag.get());
        return true;
    }

    //TODO Возможно тут надо отлавливать если пытаешься удалить связанные обьекты

    private Tag toEntity(TagDTO tagDTO) {
        return TagMapper.TAG_MAPPER.toEntity(tagDTO);
    }
    private TagDTO toDTO(Tag tag) {
        return TagMapper.TAG_MAPPER.toDTO(tag);
    }
    private List<Tag> allToEntity(List<TagDTO> tagDTOList) {
        return TagMapper.TAG_MAPPER.allToEntity(tagDTOList);
    }
    private List<TagDTO> allToDTO(List<Tag> tagList) {
        return TagMapper.TAG_MAPPER.allToDTO(tagList);
    }
}
