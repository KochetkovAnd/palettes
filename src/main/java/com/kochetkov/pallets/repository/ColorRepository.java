package com.kochetkov.pallets.repository;

import com.kochetkov.pallets.domain.Collection;
import com.kochetkov.pallets.domain.Color;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ColorRepository extends JpaRepository<Color, Long> {
    Optional<Color> findByHex(String hex);
}
