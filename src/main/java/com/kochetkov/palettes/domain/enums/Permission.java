package com.kochetkov.palettes.domain.enums;

public enum Permission {
    WATCH_PALETTES("palette:watch"),
    CREATE_PALETTES("palette:create"),
    GENERATE_PALETTES("palette:generate"),
    CREATE_COLLECTIONS("create_pallets");

    private final String permission;
    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
