package com.kochetkov.palettes.domain.enums;

public enum BaseColor {
    WHITE("white"),
    YELLOW("yellow"),
    ORANGE("orange"),
    RED("red"),
    GREEN("green"),
    AQUA("aqua"),
    BLUE("blue"),
    VIOLET("violet"),
    PINK("pink"),
    BROWN("brown"),
    GREY("grey"),
    BLACK("black");
    private final String baseColor;

    public String getBaseColors() {
        return baseColor;
    }

    BaseColor(String baseColors) {
        this.baseColor = baseColors;
    }
}
