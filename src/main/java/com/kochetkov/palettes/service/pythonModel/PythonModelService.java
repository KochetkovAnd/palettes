package com.kochetkov.palettes.service.pythonModel;

import com.kochetkov.palettes.DTO.ColorInPaletteDTO;
import com.kochetkov.palettes.service.ColorInPaletteService;
import lombok.RequiredArgsConstructor;
import netscape.javascript.JSObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PythonModelService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String pythonServiceUrl = "http://localhost:8081";

    public List<ColorInPaletteDTO> getModelGeneratedColors() {
        ResponseEntity<List<ColorInPaletteDTO>> response = restTemplate.exchange(
                pythonServiceUrl + "/generate",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<ColorInPaletteDTO>>() {}
        );
        return response.getBody();
    }
}
