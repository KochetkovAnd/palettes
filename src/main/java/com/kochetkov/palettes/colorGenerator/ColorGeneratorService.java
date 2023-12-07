package com.kochetkov.palettes.colorGenerator;


import com.kochetkov.palettes.colorGenerator.ColorSchemas.MonochromeSchema;
import com.kochetkov.palettes.colorGenerator.ColorSchemas.SequentialSchema;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.kochetkov.palettes.DTO.ColorInPaletteDTO;


import java.util.List;


@Service
@RequiredArgsConstructor
public class ColorGeneratorService {

    public List<ColorInPaletteDTO> generate(List<ColorInPaletteDTO> colorInPaletteDTOS, String schema) {
        ColorSchema colorSchema = switch (schema) {
            case "monochrome" -> new MonochromeSchema();
            case "sequential" -> new SequentialSchema();
            default -> new MonochromeSchema();
        };
        return colorSchema.insertMissing(colorInPaletteDTOS);
    }
}
