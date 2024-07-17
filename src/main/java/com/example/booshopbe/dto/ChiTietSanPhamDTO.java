package com.example.booshopbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChiTietSanPhamDTO {
    private UUID idChiTietSanPham;
    private Date ngaytao;
    private Date ngaysua;
    private int dongia;
    private int soluongton;
    private int trangthai;
    private UUID idSanPham;
    private UUID idDeGiay;
    private UUID idKichCo;
    private UUID idMauSac;

}
