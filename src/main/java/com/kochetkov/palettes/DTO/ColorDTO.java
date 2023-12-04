package com.kochetkov.palettes.DTO;

import com.kochetkov.palettes.domain.enums.BaseColor;
import lombok.Data;


@Data
public class ColorDTO {
    private String hex;
    private BaseColor baseColor;
    private String description;
}
