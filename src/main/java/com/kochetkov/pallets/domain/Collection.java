package com.kochetkov.pallets.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "collection")
@Data
public class Collection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "likes")
    private int likes;

    @ManyToOne
    @JoinColumn(name = "editor_id")
    private User editor;

    @OneToMany
    @JoinColumn(name = "collection_id")
    private List<Palette> palettes;
}
