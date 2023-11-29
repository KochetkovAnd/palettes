package com.kochetkov.pallets.service;

import com.kochetkov.pallets.DTO.PaletteColorDTO;
import com.kochetkov.pallets.domain.PaletteColor;
import com.kochetkov.pallets.domain.keys.PaletteColorKey;
import com.kochetkov.pallets.exeption.ResourceNotFoundException;
import com.kochetkov.pallets.mapper.PaletteColorMapper;
import com.kochetkov.pallets.repository.PaletteColorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//TODO требует доработки
@Service
@RequiredArgsConstructor
public class PaletteColorService {
    private final PaletteColorRepository paletteColorRepository;

    private List<PaletteColorDTO> getAll() {
        return allToDTO(paletteColorRepository.findAll());
    }

    private PaletteColorDTO getById(Long id) {
        Optional<PaletteColor> paletteColor = paletteColorRepository.findById(id);
        if (paletteColor.isPresent()) {
            return toDTO(paletteColor.get());
        }
        throw new ResourceNotFoundException("PaletteColor with id = "+ id + " not found", "");
    }
    private PaletteColorDTO create(PaletteColorDTO paletteColorDTO) {
        paletteColorRepository.save(toEntity(paletteColorDTO));
        return paletteColorDTO;
    }
    private PaletteColorDTO update(PaletteColorDTO paletteColorDTO) {
        paletteColorDTO.setId(new PaletteColorKey(paletteColorDTO.getPalette().getId(), paletteColorDTO.getColor().getId()));
        return toDTO(paletteColorRepository.save(toEntity(paletteColorDTO)));
    }
    public boolean deleteById(Long id) {
        Optional<PaletteColor> paletteColor = paletteColorRepository.findById(id);
        if (!paletteColor.isPresent()) {
            return false;
        }
        paletteColorRepository.delete(paletteColor.get());
        return true;
    }

    //TODO Возможно тут надо отлавливать если пытаешься удалить связанные обьекты

    private PaletteColor toEntity(PaletteColorDTO paletteColorDTO) {
        return PaletteColorMapper.PALETTE_COLOR_MAPPER.toEntity(paletteColorDTO);
    }
    private PaletteColorDTO toDTO(PaletteColor paletteColor) {
        return PaletteColorMapper.PALETTE_COLOR_MAPPER.toDTO(paletteColor);
    }
    private List<PaletteColor> allToEntity(List<PaletteColorDTO> paletteColorDTOList) {
        return PaletteColorMapper.PALETTE_COLOR_MAPPER.allToEntity(paletteColorDTOList);
    }
    private List<PaletteColorDTO> allToDTO(List<PaletteColor> paletteColorList) {
        return PaletteColorMapper.PALETTE_COLOR_MAPPER.allToDTO(paletteColorList);
    }
}
