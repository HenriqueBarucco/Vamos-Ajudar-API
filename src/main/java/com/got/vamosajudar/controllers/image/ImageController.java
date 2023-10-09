package com.got.vamosajudar.controllers.image;

import com.got.vamosajudar.services.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Tag(name = "Imagem", description = "Operações relacionadas a imagens.")
@RestController
@RequestMapping("v1/image")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @Operation(summary = "Obter imagem.", description = "Retornar imagem salva no servidor.")
    @GetMapping(value = "/{id}")
    public ResponseEntity<byte[]> getImage(@PathVariable String id) throws IOException {
        byte[] imageData = imageService.getImage(id);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        return new ResponseEntity<>(imageData, headers, HttpStatus.OK);
    }
}
