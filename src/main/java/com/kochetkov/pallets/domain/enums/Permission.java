package com.kochetkov.pallets.domain.enums;

public enum Permission {
    CREATE_PALLETS("create_pallets");

    private final String permission;
    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
