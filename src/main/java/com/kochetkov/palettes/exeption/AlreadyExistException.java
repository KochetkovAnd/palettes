package com.kochetkov.palettes.exeption;

public class AlreadyExistException  extends AbstractException{

    public AlreadyExistException(String message, String techInfo) {
        super(message, techInfo);
    }
}
