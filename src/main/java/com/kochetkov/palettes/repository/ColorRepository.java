package com.kochetkov.palettes.repository;

import com.kochetkov.palettes.domain.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColorRepository extends JpaRepository<Color, Long> {
    Optional<Color> findByHex(String hex);
}
