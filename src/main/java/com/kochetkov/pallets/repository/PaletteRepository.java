package com.kochetkov.pallets.repository;

import com.kochetkov.pallets.domain.Collection;
import com.kochetkov.pallets.domain.Palette;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaletteRepository extends JpaRepository<Palette, Long> {
    Optional<Palette> findByName(String name);
}
