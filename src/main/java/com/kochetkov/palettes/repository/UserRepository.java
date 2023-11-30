package com.kochetkov.palettes.repository;

import com.kochetkov.palettes.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User getByUsername(String username);
    Optional<User> findByUsername(String username);

}
