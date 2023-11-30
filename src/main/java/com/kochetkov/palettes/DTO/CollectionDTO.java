package com.kochetkov.palettes.DTO;

import com.kochetkov.palettes.domain.Palette;
import com.kochetkov.palettes.domain.User;
import lombok.Data;

import java.util.List;

@Data
public class CollectionDTO {
    private long id;
    private String name;
    private int likes;
    private User editor;
    private List<Palette> palettes;
}
