package com.kochetkov.pallets.repository;

import com.kochetkov.pallets.domain.Palette;
import com.kochetkov.pallets.domain.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {
    Optional<Tag> findByName(String name);
}
