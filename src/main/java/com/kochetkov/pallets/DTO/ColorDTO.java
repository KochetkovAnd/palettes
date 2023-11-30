package com.kochetkov.pallets.DTO;

import com.kochetkov.pallets.domain.enums.BaseColor;
import lombok.Data;


@Data
public class ColorDTO {
    private long id;
    private String hex;
    private BaseColor baseColor;
    private String description;
}
