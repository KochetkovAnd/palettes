package com.kochetkov.palettes.domain;

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

    @Column(name = "isPrivate")
    private boolean isPrivate;

    @Column(name = "model_type")
    private String modelType;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private User creator;

    @ManyToMany
    @JoinTable (
            name = "palette_tag",
            joinColumns = @JoinColumn(name = "palette_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_name")
    )
    private List<Tag> tags;

    @OneToMany
    @JoinColumn(name = "palette_id")
    private List<ColorInPalette> colorInPalettes;

}
