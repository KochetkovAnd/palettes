package com.kochetkov.palettes.controller;

import com.kochetkov.palettes.DTO.ColorInPaletteDTO;
import com.kochetkov.palettes.domain.ColorInPalette;
import com.kochetkov.palettes.service.ColorInPaletteService;
import com.kochetkov.palettes.service.PaletteService;
import com.kochetkov.palettes.service.pythonModel.PythonModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/color_in_palette")
public class ColorInPaletteController {

    private final ColorInPaletteService colorInPaletteService;
    private final PythonModelService pythonModelService;

    @PostMapping("/generate/{scheme}")
    public List<ColorInPaletteDTO> generate(@RequestBody List<ColorInPaletteDTO> colorInPalettes, @PathVariable String scheme) {
        return this.colorInPaletteService.generate(colorInPalettes, scheme);
    }

    @GetMapping("/generate-by-model")
    public List<ColorInPaletteDTO> generateByModel() {
        return this.pythonModelService.getModelGeneratedColors();
    }
}
