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
public class ChiTietHoaDonDTO {
    private UUID idChiTietHoaDon;
    private UUID idHoaDon;
    private UUID idChiTietSanPham;
    private int soluong;
}
