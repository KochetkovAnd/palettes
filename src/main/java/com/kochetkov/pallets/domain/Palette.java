package com.kochetkov.pallets.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "palette")
@Data
public class Palette {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "model_type")
    private String modelType;

    @Column(name = "theme")
    private String theme;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    @ManyToMany
    @JoinTable (
            name = "palette_tag",
            joinColumns = @JoinColumn(name = "palette_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    List<Tag> tags;

    @OneToMany
    @JoinColumn(name = "palette_id")
    List<PaletteColor> paletteColors;

}
