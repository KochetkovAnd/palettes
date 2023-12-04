package com.kochetkov.palettes.repository;

import com.kochetkov.palettes.domain.Palette;
import com.kochetkov.palettes.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaletteRepository extends JpaRepository<Palette, Long> {
    Optional<Palette> findByName(String name);
//    List<Palette> getAllByPrivateIsFalse(); //TODO проверить правильно ли работает
    List<Palette> getAllByCreator(User creator);

    List<Palette> getAllByIsPrivate(Boolean isPrivate);
}
