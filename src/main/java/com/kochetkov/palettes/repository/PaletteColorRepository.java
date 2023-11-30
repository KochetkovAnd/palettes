package com.kochetkov.palettes.repository;

import com.kochetkov.palettes.domain.PaletteColor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaletteColorRepository extends JpaRepository<PaletteColor, Long> {
}
