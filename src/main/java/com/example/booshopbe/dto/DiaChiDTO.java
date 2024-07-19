package com.example.booshopbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DiaChiDTO {
    private UUID idDiaChi;
    private UUID idKhachHang;
    private String thanhpho;
    private String quanhuyen;
    private String phuongxa;
    private String chitiet;
}
