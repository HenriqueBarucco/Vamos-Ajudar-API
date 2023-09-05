package com.got.vamosajudar.services;

import com.got.vamosajudar.entities.Ong;
import com.got.vamosajudar.entities.Pix;
import com.got.vamosajudar.exceptions.exceptions.ResourceNotFoundException;
import com.got.vamosajudar.utils.HttpRequest;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Service;

import java.util.Base64;

@Service
public class PixService {
    private final String API_URL = "https://gerarqrcodepix.com.br/api/v1";

    public Pix getPix(Ong ong) {
        if (ong.getChavePix() == null) throw new ResourceNotFoundException("Chave PIX não cadastrada.");

        Response response = HttpRequest.get(API_URL, buildParamsString(ong));

        try {
            if (response.isSuccessful() && response.header("Content-Type", "").equalsIgnoreCase("image/png")) {
                ResponseBody responseBody = response.body();
                if (responseBody != null) {

                    byte[] imageBytes = responseBody.bytes();

                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    String brcode = response.header("Brcode");

                    return new Pix(base64Image, brcode);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao converter imagem para base64");
        }
        throw new RuntimeException("Não foi possível obter QRCODE Pix.");
    }

    private String buildParamsString(Ong ong) {
        StringBuilder sb = new StringBuilder();

        sb.append("nome=").append(ong.getName())
                .append("&cidade=").append(ong.getAddress().city())
                .append("&chave=").append(ong.getChavePix())
                .append("&saida=qr&tamanho=256");

        return sb.toString();
    }
}
