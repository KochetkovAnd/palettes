package com.kochetkov.pallets.repository;

import com.kochetkov.pallets.domain.Collection;
import com.kochetkov.pallets.domain.Palette;
import com.kochetkov.pallets.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PaletteRepository extends JpaRepository<Palette, Long> {
    Optional<Palette> findByName(String name);
    List<Palette> getAllByPrivateIsFalse(); //TODO проверить правильно ли работает
    List<Palette> getAllByCreator(User creator);
}
