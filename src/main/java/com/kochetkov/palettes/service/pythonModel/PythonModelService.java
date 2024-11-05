package com.kochetkov.palettes.service.pythonModel;

import com.kochetkov.palettes.DTO.ColorInPaletteDTO;
import com.kochetkov.palettes.service.ColorInPaletteService;
import lombok.RequiredArgsConstructor;
import netscape.javascript.JSObject;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

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

    public List<String> getPictureGeneratedColors(MultipartFile file) throws IOException {


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.MULTIPART_FORM_DATA);

        ByteArrayResource fileAsResource = new ByteArrayResource(file.getBytes()) {
            @Override
            public String getFilename() {
                return file.getOriginalFilename();
            }
        };

        MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
        body.put("file", Collections.singletonList(fileAsResource));

        HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

        ResponseEntity<List<String>> response = restTemplate.exchange(
                pythonServiceUrl + "/generate-by-picture",
                HttpMethod.POST,
                requestEntity,
                new ParameterizedTypeReference<List<String>>() {}
        );
        return response.getBody();
    }




}
