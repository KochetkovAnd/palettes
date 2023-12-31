package com.kochetkov.palettes.service;

import com.kochetkov.palettes.DTO.PaletteDTO;
import com.kochetkov.palettes.domain.Palette;
import com.kochetkov.palettes.exeption.AlreadyExistException;
import com.kochetkov.palettes.exeption.ResourceNotFoundException;
import com.kochetkov.palettes.mapper.PaletteMapper;
import com.kochetkov.palettes.repository.PaletteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaletteService {

    private final PaletteRepository paletteRepository;


    private final UserService userService;
    private final ColorInPaletteService colorInPaletteService;

    private List<PaletteDTO> getAll() {
        return allToDTO(paletteRepository.findAll());
    }

    private PaletteDTO getById(Long id) {
        Optional<Palette> palette = paletteRepository.findById(id);
        if (palette.isPresent()) {
            return toDTO(palette.get());
        }
        throw new ResourceNotFoundException("Palette with id = "+ id + " not found", "");
    }

    private PaletteDTO create(PaletteDTO paletteDTO) {
        if (!paletteRepository.findByName(paletteDTO.getName()).isPresent()) {
            paletteRepository.save(toEntity(paletteDTO));
            return toDTO(paletteRepository.findByName(paletteDTO.getName()).get());
        }
        throw new AlreadyExistException("Palette with name = " + paletteDTO.getName() + " already exist", "");
    }

    private PaletteDTO update(PaletteDTO paletteDTO) {
        if (!paletteRepository.findById(paletteDTO.getId()).isPresent()) {
            paletteRepository.save(toEntity(paletteDTO));
            return toDTO(paletteRepository.getById(paletteDTO.getId()));
        }
        throw new ResourceNotFoundException("Palette with id = "+ paletteDTO.getId() + " not found", "");
    }

    public boolean deleteById(Long id) {
        Optional<Palette> palette = paletteRepository.findById(id);
        if (!palette.isPresent()) {
            return false;
        }
        paletteRepository.delete(palette.get());
        return true;
    }


    @PreAuthorize("hasAuthority('palette:watch')")
    public List<PaletteDTO> getAllByCurrentUser() {
        return allToDTO(paletteRepository.getAllByCreator(userService.getCurrentUser()));
    }

    @PreAuthorize("hasAuthority('palette:watch')")
    public List<PaletteDTO> getAllAvailablePalettes() {
        return allToDTO(paletteRepository.getAllByIsPrivate(false));
    }

    public PaletteDTO createNew(PaletteDTO paletteDTO) {
        if (!paletteRepository.findByName(paletteDTO.getName()).isPresent()) {
            paletteDTO.setCreator(userService.getCurrentUser());
            colorInPaletteService.createAll(paletteDTO.getColorInPalettes());
            paletteRepository.save(toEntity(paletteDTO));
            return toDTO(paletteRepository.findByName(paletteDTO.getName()).get());
        }
        throw new AlreadyExistException("Palette with name = " + paletteDTO.getName() + " already exist", "");
    }


    //TODO Возможно тут надо отлавливать если пытаешься удалить связанные обьекты

    private Palette toEntity(PaletteDTO paletteDTO) {
        return PaletteMapper.PALETTE_MAPPER.toEntity(paletteDTO);
    }
    private PaletteDTO toDTO(Palette palette) {
        return PaletteMapper.PALETTE_MAPPER.toDTO(palette);
    }
    private List<Palette> allToEntity(List<PaletteDTO> paletteDTOList) {
        return PaletteMapper.PALETTE_MAPPER.allToEntity(paletteDTOList);
    }
    private List<PaletteDTO> allToDTO(List<Palette> paletteList) {
        return PaletteMapper.PALETTE_MAPPER.allToDTO(paletteList);
    }
}
