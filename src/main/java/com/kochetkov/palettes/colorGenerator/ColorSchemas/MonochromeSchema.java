package com.kochetkov.palettes.colorGenerator.ColorSchemas;

import com.kochetkov.palettes.DTO.ColorInPaletteDTO;
import com.kochetkov.palettes.colorGenerator.ColorSchema;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MonochromeSchema implements ColorSchema {

    private final float randomPart = 0.2f;
    private final int N = 5;
    private final Random random = new Random();
    @Override
    public List<ColorInPaletteDTO> insertMissing(List<ColorInPaletteDTO> colorInPaletteDTOList) {
        if (colorInPaletteDTOList.isEmpty()) {
            return generateOnColor(generateRandomColor(), N);
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
            List<ColorInPaletteDTO> list = generateOnColor(color, colorInPaletteDTOList.size());
            if (index != -1) {
                for (int i = 0; i < list.size(); i++) {
                    if (colorInPaletteDTOList.get(i).getHex() != "") {
                        list.set(i, colorInPaletteDTOList.get(i));
                    }
                }
            }
            return list;
        }
    }

    public List<ColorInPaletteDTO> generateOnColor(Color color, int n) {
        float[] hsbBase = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        List<ColorInPaletteDTO> list = new ArrayList<>();
        for (int i = n; i > 0; i--) {
            float hueVariation = (random.nextFloat() - 0.5f) * randomPart;
            float saturationVariation = (random.nextFloat() - 0.5f) * randomPart;

            float hue = clipHue(hsbBase[0] + hueVariation);
            float saturation = clip(hsbBase[1] + saturationVariation);
            float brightness = (float) i / n;

            ColorInPaletteDTO dto = new ColorInPaletteDTO();
            dto.setColorRole("");
            dto.setHex(RGBtoHEX(new Color(Color.HSBtoRGB(hue, saturation, brightness))));
            list.add(dto);
        }
        return list;
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
