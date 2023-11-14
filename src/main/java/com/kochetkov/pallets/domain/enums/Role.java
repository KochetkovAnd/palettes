package com.kochetkov.pallets.domain.enums;

import java.util.Set;


public enum Role {
    ;


    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    // TODO
}
