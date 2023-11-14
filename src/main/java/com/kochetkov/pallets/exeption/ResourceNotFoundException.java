package com.kochetkov.pallets.exeption;

public class ResourceNotFoundException extends AbstractException {

    public ResourceNotFoundException(String message, String techInfo) {
        super(message, techInfo);
    }
}
