package com.kochetkov.palettes.DTO;

import com.kochetkov.palettes.domain.ColorInPalette;
import com.kochetkov.palettes.domain.Tag;
import com.kochetkov.palettes.domain.User;
import lombok.Data;


import java.util.List;

@Data
public class PaletteDTO {
    private long id;
    private String name;
    private boolean isPrivate;
    private String modelType;
    private User creator;
    private List<Tag> tags;
    private List<ColorInPalette> ColorInPalettes;
}
