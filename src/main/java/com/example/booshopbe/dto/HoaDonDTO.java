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
public class HoaDonDTO {
    private UUID idHoaDon;
    private UUID idKhachHang;
    private String idKhuyenMai;
    private int tongtien;
    private Date ngaytao;
    private String diachi;
    private int idTrangThaiDonHang;
    private int idPhuongThucThanhToan;
}
