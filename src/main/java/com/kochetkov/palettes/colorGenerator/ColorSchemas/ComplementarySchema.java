package com.kochetkov.palettes.colorGenerator.ColorSchemas;

import com.kochetkov.palettes.DTO.ColorInPaletteDTO;
import com.kochetkov.palettes.colorGenerator.ColorSchema;
import org.springframework.security.core.parameters.P;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComplementarySchema implements ColorSchema {

    private final float randomPart = 0.2f;
    private final int N = 5;
    private final Random random = new Random();
    @Override
    public List<ColorInPaletteDTO> insertMissing(List<ColorInPaletteDTO> colorInPaletteDTOList) {
        if (colorInPaletteDTOList.isEmpty()) {
            return generateOnColor(generateRandomColor());
        } else {
            int index = -1;
            Color color = generateRandomColor();
            for (int i = 0; i < colorInPaletteDTOList.size(); i++) {
                if (colorInPaletteDTOList.get(i).getHex() != "") {
                    color = HEXtoRGB(colorInPaletteDTOList.get(i).getHex());
                    index = i;
                    break;
                }
            }
            List<ColorInPaletteDTO> list;
            if (index != -1) {
                list = switch (index) {
                    case 0 -> generateOnColor(getMainFromFirst(color));
                    case 1 -> generateOnColor(getMainFromSecond(color));
                    case 3 -> generateOnColor(getMainFromFourth(color));
                    case 4 -> generateOnColor(getMainFromFifth(color));
                    default -> generateOnColor(color);
                };
                for (int i = 0; i < list.size(); i++) {
                    if (colorInPaletteDTOList.get(i).getHex() != "") {
                        list.set(i, colorInPaletteDTOList.get(i));
                    }
                }
            } else {
                list = generateOnColor(color);
            }
            return list;
        }
    }
    public List<ColorInPaletteDTO> generateOnColor(Color color) {
        float[] hsbBase = java.awt.Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        List<ColorInPaletteDTO> list = new ArrayList<>();

        ColorInPaletteDTO dto = new ColorInPaletteDTO();
        dto.setColorRole("");
        dto.setHex(RGBtoHEX(getFirstFromThird(hsbBase)));
        list.add(dto);

        dto = new ColorInPaletteDTO();
        dto.setColorRole("");
        dto.setHex(RGBtoHEX(getSecondFromThird(hsbBase)));
        list.add(dto);

        dto = new ColorInPaletteDTO();
        dto.setColorRole("");
        dto.setHex(RGBtoHEX(color));
        list.add(dto);

        dto = new ColorInPaletteDTO();
        dto.setColorRole("");
        dto.setHex(RGBtoHEX(getFourthFromThird(hsbBase)));
        list.add(dto);

        dto = new ColorInPaletteDTO();
        dto.setColorRole("");
        dto.setHex(RGBtoHEX(getFifthFromThird(hsbBase)));
        list.add(dto);

        return list;
    }
    public Color getFirstFromThird(float[] hsbBase) {
        float hueVariation = (random.nextFloat() - 0.5f) * randomPart;
        float saturationVariation = (random.nextFloat() - 0.5f) * randomPart;

        float hue = clipHue(hsbBase[0] + 0.5f + hueVariation);
        float saturation = clip(hsbBase[1] + saturationVariation);
        float brightness = 0.98f;

        return new Color(Color.HSBtoRGB(hue, saturation, brightness));
    }
    public Color getSecondFromThird(float[] hsbBase) {
        float hueVariation = (random.nextFloat() - 0.5f) * randomPart;
        float saturationVariation = (random.nextFloat() - 0.5f) * randomPart;

        float hue = clipHue(hsbBase[0] + 0.5f + hueVariation);
        float saturation = clip(hsbBase[1] + saturationVariation - 0.3f);
        float brightness = 0.65f;

        return new Color(Color.HSBtoRGB(hue, saturation, brightness));
    }
    public Color getFourthFromThird(float[] hsbBase) {
        float hueVariation = (random.nextFloat() - 0.5f) * randomPart;
        float saturationVariation = (random.nextFloat() - 0.5f) * randomPart;

        float hue = clipHue(hsbBase[0] + hueVariation);
        float saturation = clip(hsbBase[1] + saturationVariation - 0.2f);
        float brightness = 0.73f;

        return new Color(Color.HSBtoRGB(hue, saturation, brightness));
    }
    public Color getFifthFromThird(float[] hsbBase) {
        float hueVariation = (random.nextFloat() - 0.5f) * randomPart;
        float saturationVariation = (random.nextFloat() - 0.5f) * randomPart;

        float hue = clipHue(hsbBase[0] + hueVariation);
        float saturation = clip(hsbBase[1] + saturationVariation - 0.4f);
        float brightness = 0.48f;

        return new Color(Color.HSBtoRGB(hue, saturation, brightness));
    }
    public Color getMainFromFirst(Color color) {
        float[] hsbBase = java.awt.Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        float hue = clipHue(hsbBase[0] + 0.5f);
        float saturation = hsbBase[1];
        float brightness = 0.98f;
        return new Color(Color.HSBtoRGB(hue, saturation, brightness));
    }
    public Color getMainFromSecond(Color color) {
        float[] hsbBase = java.awt.Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        float hue = clipHue(hsbBase[0] + 0.5f);
        float saturation = clip(hsbBase[1] + 0.3f);
        float brightness = 0.98f;
        return new Color(Color.HSBtoRGB(hue, saturation, brightness));
    }
    public Color getMainFromFourth(Color color) {
        float[] hsbBase = java.awt.Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        float hue = hsbBase[0];
        float saturation = clip(hsbBase[1] + 0.2f);
        float brightness = 0.98f;
        return new Color(Color.HSBtoRGB(hue, saturation, brightness));
    }
    public Color getMainFromFifth(Color color) {
        float[] hsbBase = java.awt.Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        float hue = hsbBase[0];
        float saturation = clip(hsbBase[1] + 0.4f);
        float brightness = 0.98f;
        return new Color(Color.HSBtoRGB(hue, saturation, brightness));
    }
    private Color HEXtoRGB(String hex) {
        return new Color(Integer.parseInt(hex.substring(0,2), 16), Integer.parseInt(hex.substring(2,4), 16), Integer.parseInt(hex.substring(4,6), 16));
    }
    private String RGBtoHEX(Color color) {
        return String.format("%02X%02X%02X", color.getRed(), color.getGreen(), color.getBlue());
    }
    private Color generateRandomColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
    private static float clip(float value) {
        return Math.min(1, Math.max(0, value));
    }
    private static float clipHue(float value) {
        if (value > 1) {
            return value - 1;
        } else if (value < 0) {
            return value + 1;
        }
        return value;

    }

}
