package com.got.vamosajudar.entities;

import com.got.vamosajudar.controllers.ong.dto.DonateDto;
import lombok.Data;

@Data
public class Pix {
    private String qrcode;
    private String brcode;

    public Pix(String qrcode, String brcode) {
        this.qrcode = qrcode;
        this.brcode = brcode;
    }

    public DonateDto toDonate() {
        return new DonateDto(qrcode, brcode);
    }
}
