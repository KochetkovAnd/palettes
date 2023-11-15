package com.kochetkov.pallets.repository;

import com.kochetkov.pallets.domain.PaletteColor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaletteColorRepository extends JpaRepository<PaletteColor, Long> {
}
