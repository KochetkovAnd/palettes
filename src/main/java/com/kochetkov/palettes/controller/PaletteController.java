package com.kochetkov.palettes.controller;

import com.kochetkov.palettes.DTO.PaletteDTO;
import com.kochetkov.palettes.service.PaletteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/palette")
public class PaletteController {

    private final PaletteService paletteService;
    @GetMapping("/your_palettes")
    public List<PaletteDTO> getAllByCurrentUser() {
        return paletteService.getAllByCurrentUser();
    }
}
