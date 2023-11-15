package com.kochetkov.pallets.DTO;

import com.kochetkov.pallets.domain.Palette;
import com.kochetkov.pallets.domain.User;
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
