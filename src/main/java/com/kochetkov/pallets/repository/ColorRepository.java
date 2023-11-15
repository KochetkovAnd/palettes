package com.kochetkov.pallets.repository;

import com.kochetkov.pallets.domain.Color;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ColorRepository extends JpaRepository<Color, Long> {
}
