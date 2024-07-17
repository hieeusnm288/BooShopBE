package com.example.booshopbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SanPhamDTO {
    private UUID idSanPham;
    private String tensanpham;
    private Date ngaytao;
    private String mota;
    private int trangthai;
    private UUID idThuongHieu;
}
