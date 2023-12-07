package com.kochetkov.palettes.colorGenerator;


import com.kochetkov.palettes.domain.Palette;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.kochetkov.palettes.DTO.ColorInPaletteDTO;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ColorGeneratorService {
    private final float shift = 0.2f;
    private final Random random = new Random();
    public List<ColorInPaletteDTO> generate(List<ColorInPaletteDTO> colorInPaletteDTOS, String schema) {
        return switch (schema) {
            case "monochrome" -> generateMonochrome(colorInPaletteDTOS);
            case "sequential" -> generateSequential(colorInPaletteDTOS);
            case "complementary" -> generateComplementary(colorInPaletteDTOS);
            default -> null;
        };
    }
    public List<ColorInPaletteDTO> generateMonochrome(List<ColorInPaletteDTO> colorInPaletteDTOS) {
        if (colorInPaletteDTOS.isEmpty()) {
            int n = 5;
            Color baseColor = generateRandomColor();
            return generateEmptyMonochromeOfN(baseColor, n);
        } else {
            Color baseColor = generateRandomColor();
            for (int i = 0; i < colorInPaletteDTOS.size(); i++) {
                if (colorInPaletteDTOS.get(i).getHex() != "") {
                    String hex = colorInPaletteDTOS.get(i).getHex();
                    baseColor = new Color(Integer.parseInt(hex.substring(0,1), 16), Integer.parseInt(hex.substring(2,3), 16), Integer.parseInt(hex.substring(4,5), 16));
                    break;
                }
            }
            List<ColorInPaletteDTO> list = generateEmptyMonochromeOfN(baseColor, colorInPaletteDTOS.size());
            for (int i = 0; i < list.size(); i++) {
                if (colorInPaletteDTOS.get(i).getHex() != "") {
                    list.set(i, colorInPaletteDTOS.get(i));
                }
            }
            return list;
        }
    }

    public List<ColorInPaletteDTO> generateEmptyMonochromeOfN(Color color, int n) {
        float[] hsbBase = Color.RGBtoHSB(color.getRed(), color.getGreen(), color.getBlue(), null);
        List<ColorInPaletteDTO> list = new ArrayList<>();
        for (int i = n; i > 0; i--) {
            float hueVariation = (random.nextFloat() - 0.5f) * shift;
            float saturationVariation = (random.nextFloat() - 0.5f) * shift;

            float hue = clip(hsbBase[0] + hueVariation);
            float saturation = clip(hsbBase[1] + saturationVariation);
            float brightness = (float) i / n;

            Color nColor = new Color(Color.HSBtoRGB(hue, saturation, brightness));
            ColorInPaletteDTO dto = new ColorInPaletteDTO();
            dto.setColorRole("");
            dto.setHex(RGBtoHEX(nColor.getRed(), nColor.getGreen(), nColor.getBlue()));
            list.add(dto);
        }
        return list;
    }


    public List<ColorInPaletteDTO> generateSequential(List<ColorInPaletteDTO> colorInPaletteDTOS) {
        return null;
    }
    public List<ColorInPaletteDTO> generateComplementary(List<ColorInPaletteDTO> colorInPaletteDTOS) {
        return null;
    }

    private Color generateRandomColor() {
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }
    private String RGBtoHEX(int red, int green, int blue) {
        return String.format("%02X%02X%02X", red, green, blue);
    }

    private static float clip(float value) {
        return Math.min(1, Math.max(0, value));
    }

}
