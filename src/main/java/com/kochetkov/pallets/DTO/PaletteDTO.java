package com.kochetkov.pallets.DTO;

import com.kochetkov.pallets.domain.PaletteColor;
import com.kochetkov.pallets.domain.Tag;
import com.kochetkov.pallets.domain.User;
import lombok.Data;


import java.util.List;

@Data
public class PaletteDTO {
    private long id;
    private String name;
    private boolean isPrivate;
    private String modelType;
    private String theme;
    private User creator;
    private List<Tag> tags;
    private List<PaletteColor> paletteColors;
}
