package com.kochetkov.palettes.repository;

import com.kochetkov.palettes.domain.ColorInPalette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorInPaletteRepository extends JpaRepository<ColorInPalette, Long> {
}
