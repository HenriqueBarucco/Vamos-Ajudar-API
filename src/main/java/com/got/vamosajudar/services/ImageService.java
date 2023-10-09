package com.got.vamosajudar.services;

import com.got.vamosajudar.exceptions.exceptions.ImageException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;

@Service
public class ImageService {
    private static final String IMAGE_DIRECTORY = "/opt/vamos-ajudar/images";

    public String saveImage(byte[] imageData, String fileExtension) {
        if (fileExtension == null || fileExtension.isEmpty()) {
            throw new IllegalArgumentException("Tipo do arquivo não pode ser nulo.");
        }

        String fileName = UUID.randomUUID() + "." + fileExtension;
        String filePath = IMAGE_DIRECTORY + "/" + fileName;

        File directory = new File(IMAGE_DIRECTORY);
        if (!directory.exists()) {
            boolean created = directory.mkdirs();
            if (!created) {
                throw new ImageException("Falha ao criar diretório de imagens: " + IMAGE_DIRECTORY);
            }
        }

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            fos.write(imageData);
            return fileName;
        } catch (IOException e) {
            throw new ImageException("Falha ao salvar imagem.");
        }
    }

    public byte[] getImage(String fileName) throws IOException {
        String filePath = IMAGE_DIRECTORY + "/" + fileName;

        File imageFile = new File(filePath);
        if (!imageFile.exists()) {
            throw new ImageException("Imagem não encontrada: " + fileName);
        }

        return Files.readAllBytes(imageFile.toPath());
    }

    public byte[] base64ToImage(String image) {
        try {
            return java.util.Base64.getDecoder().decode(image);
        } catch (Exception e) {
            throw new ImageException("Falha ao converter imagem para base64");
        }
    }
}