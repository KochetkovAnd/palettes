package com.kochetkov.pallets.domain.keys;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaletteColorKey implements Serializable {

    @Column(name = "palette_id")
    long palette_id;

    @Column(name = "color_id")
    long color_id;

}
