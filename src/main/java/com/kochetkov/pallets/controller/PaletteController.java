package com.kochetkov.pallets.controller;

import com.kochetkov.pallets.DTO.PaletteDTO;
import com.kochetkov.pallets.service.PaletteService;
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

//    @GetMapping("")
//    public List<PaletteDTO> getAll() {
//        return paletteService.getAllPublic();
//    }

    @GetMapping("/your_palettes")
    public List<PaletteDTO> getAllByCurrentUser() {
        return paletteService.getAllByCurrentUser();
    }
}
