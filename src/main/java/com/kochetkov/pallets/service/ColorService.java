package com.kochetkov.pallets.service;

import com.kochetkov.pallets.DTO.ColorDTO;
import com.kochetkov.pallets.domain.Color;
import com.kochetkov.pallets.exeption.AlreadyExistException;
import com.kochetkov.pallets.exeption.ResourceNotFoundException;
import com.kochetkov.pallets.mapper.ColorMapper;
import com.kochetkov.pallets.repository.ColorRepository;
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

    private ColorDTO getById(Long id) {
        Optional<Color> color = colorRepository.findById(id);
        if (color.isPresent()) {
            return toDTO(color.get());
        }
        throw new ResourceNotFoundException("Color with id = "+ id + " not found", "");
    }

    private ColorDTO create(ColorDTO colorDTO) {
        if (!colorRepository.findByHex(colorDTO.getHex()).isPresent()) {
            colorRepository.save(toEntity(colorDTO));
            return toDTO(colorRepository.findByHex(colorDTO.getHex()).get());
        }
        throw new AlreadyExistException("Color with Hex = " + colorDTO.getHex() + " already exist", "");
    }

    private ColorDTO update(ColorDTO colorDTO) {
        if (!colorRepository.findById(colorDTO.getId()).isPresent()) {
            colorRepository.save(toEntity(colorDTO));
            return toDTO(colorRepository.getById(colorDTO.getId()));
        }
        throw new ResourceNotFoundException("Color with id = "+ colorDTO.getId() + " not found", "");
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
