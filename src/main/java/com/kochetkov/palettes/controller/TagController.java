package com.kochetkov.palettes.controller;

import com.kochetkov.palettes.DTO.PaletteDTO;
import com.kochetkov.palettes.DTO.TagDTO;
import com.kochetkov.palettes.service.PaletteService;
import com.kochetkov.palettes.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/tag")
public class TagController {
    private final TagService tagService;
    @GetMapping()
    public List<TagDTO> getAll() {
        return tagService.getAll();
    }
}
