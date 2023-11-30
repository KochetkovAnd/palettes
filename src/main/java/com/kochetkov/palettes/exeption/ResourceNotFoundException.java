package com.kochetkov.palettes.exeption;

public class ResourceNotFoundException extends AbstractException {

    public ResourceNotFoundException(String message, String techInfo) {
        super(message, techInfo);
    }
}
