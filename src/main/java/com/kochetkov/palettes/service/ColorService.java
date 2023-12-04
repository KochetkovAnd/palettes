package com.kochetkov.palettes.service;

import com.kochetkov.palettes.DTO.ColorDTO;
import com.kochetkov.palettes.domain.Color;
import com.kochetkov.palettes.exeption.AlreadyExistException;
import com.kochetkov.palettes.exeption.ResourceNotFoundException;
import com.kochetkov.palettes.mapper.ColorMapper;
import com.kochetkov.palettes.repository.ColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ColorService {
    private final ColorRepository colorRepository;

    private List<ColorDTO> getAll() {
        return allToDTO(colorRepository.findAll());
    }
    private ColorDTO create(ColorDTO colorDTO) {
        if (!colorRepository.findByHex(colorDTO.getHex()).isPresent()) {
            colorRepository.save(toEntity(colorDTO));
            return toDTO(colorRepository.findByHex(colorDTO.getHex()).get());
        }
       throw new AlreadyExistException("Color with Hex = " + colorDTO.getHex() + " already exist", "");
    }

    public boolean deleteById(Long id) {
        Optional<Color> color = colorRepository.findById(id);
        if (!color.isPresent()) {
            return false;
        }
        colorRepository.delete(color.get());
        return true;
    }

    //TODO Возможно тут надо отлавливать если пытаешься удалить связанные обьекты

    private Color toEntity(ColorDTO colorDTO) {
        return ColorMapper.COLOR_MAPPER.toEntity(colorDTO);
    }
    private ColorDTO toDTO(Color color) {
        return ColorMapper.COLOR_MAPPER.toDTO(color);
    }
    private List<Color> allToEntity(List<ColorDTO> colorDTOList) {
        return ColorMapper.COLOR_MAPPER.allToEntity(colorDTOList);
    }
    private List<ColorDTO> allToDTO(List<Color> colorList) {
        return ColorMapper.COLOR_MAPPER.allToDTO(colorList);
    }
}
