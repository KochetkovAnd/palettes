package com.kochetkov.pallets.repository;

import com.kochetkov.pallets.domain.Collection;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollectionRepository extends JpaRepository<Collection, Long> {
}
