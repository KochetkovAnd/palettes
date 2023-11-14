package com.kochetkov.pallets.domain.enums;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


public enum Role {
    USER(new HashSet<Permission>(){{
        add((Permission.CREATE_PALLETS));
    }}),
    EDITOR(new HashSet<Permission>(){{
        add((Permission.CREATE_PALLETS));
        add((Permission.CREATE_COLLECTIONS));
    }});


    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
