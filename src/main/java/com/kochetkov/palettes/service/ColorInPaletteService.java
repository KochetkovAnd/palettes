package com.kochetkov.palettes.service;

import com.kochetkov.palettes.DTO.ColorInPaletteDTO;
import com.kochetkov.palettes.domain.ColorInPalette;
import com.kochetkov.palettes.exeption.ResourceNotFoundException;
import com.kochetkov.palettes.mapper.ColorInPaletteMapper;
import com.kochetkov.palettes.repository.ColorInPaletteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//TODO требует доработки
@Service
@RequiredArgsConstructor
public class ColorInPaletteService {
    private final ColorInPaletteRepository ColorInPaletteRepository;

    private List<ColorInPaletteDTO> getAll() {
        return allToDTO(ColorInPaletteRepository.findAll());
    }

    private ColorInPaletteDTO getById(Long id) {
        Optional<ColorInPalette> ColorInPalette = ColorInPaletteRepository.findById(id);
        if (ColorInPalette.isPresent()) {
            return toDTO(ColorInPalette.get());
        }
        throw new ResourceNotFoundException("ColorInPalette with id = "+ id + " not found", "");
    }
    private ColorInPaletteDTO create(ColorInPaletteDTO ColorInPaletteDTO) {
        ColorInPaletteRepository.save(toEntity(ColorInPaletteDTO));
        return ColorInPaletteDTO;
    }
    private ColorInPaletteDTO update(ColorInPaletteDTO ColorInPaletteDTO) {
//        ColorInPaletteDTO.setId(new ColorInPaletteKey(ColorInPaletteDTO.getPalette().getId(), ColorInPaletteDTO.getColor().getId()));
        return toDTO(ColorInPaletteRepository.save(toEntity(ColorInPaletteDTO)));
    }
    public boolean deleteById(Long id) {
        Optional<ColorInPalette> ColorInPalette = ColorInPaletteRepository.findById(id);
        if (!ColorInPalette.isPresent()) {
            return false;
        }
        ColorInPaletteRepository.delete(ColorInPalette.get());
        return true;
    }

    public List<ColorInPaletteDTO> generate(List<ColorInPaletteDTO> colorInPaletteDTOS, String scheme) {

        //TODO Сделать нормальную логику, это затычка
        List<ColorInPaletteDTO> list = new ArrayList<ColorInPaletteDTO>();
        for (int i = 0;  i < 8; i++) {
            ColorInPaletteDTO dto = new ColorInPaletteDTO();
            dto.setColorRole("role");
            dto.setHex(String.valueOf(i) + "5" + i + "5" + i +"5");
            list.add(dto);
        }
        return list;
    }

    //TODO Возможно тут надо отлавливать если пытаешься удалить связанные обьекты

    private ColorInPalette toEntity(ColorInPaletteDTO ColorInPaletteDTO) {
        return ColorInPaletteMapper.COLOR_IN_PALETTE_MAPPER.toEntity(ColorInPaletteDTO);
    }
    private ColorInPaletteDTO toDTO(ColorInPalette ColorInPalette) {
        return ColorInPaletteMapper.COLOR_IN_PALETTE_MAPPER.toDTO(ColorInPalette);
    }
    private List<ColorInPalette> allToEntity(List<ColorInPaletteDTO> ColorInPaletteDTOList) {
        return ColorInPaletteMapper.COLOR_IN_PALETTE_MAPPER.allToEntity(ColorInPaletteDTOList);
    }
    private List<ColorInPaletteDTO> allToDTO(List<ColorInPalette> ColorInPaletteList) {
        return ColorInPaletteMapper.COLOR_IN_PALETTE_MAPPER.allToDTO(ColorInPaletteList);
    }
}
