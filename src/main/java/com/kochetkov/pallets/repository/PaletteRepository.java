package com.kochetkov.pallets.repository;

import com.kochetkov.pallets.domain.Palette;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaletteRepository extends JpaRepository<Palette, Long> {
}
