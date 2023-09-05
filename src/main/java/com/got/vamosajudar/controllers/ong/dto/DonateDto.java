package com.got.vamosajudar.controllers.ong.dto;

import lombok.Data;

@Data
public class DonateDto {
    private String qrcode64;
    private String brcode;

    public DonateDto(String qrcode64, String brcode) {
        this.qrcode64 = qrcode64;
        this.brcode = brcode;
    }
}
