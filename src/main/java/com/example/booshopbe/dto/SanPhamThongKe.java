package com.example.booshopbe.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SanPhamThongKe {
    private String tenSanPham;
    private String hinhAnh;
    private int soLuong;
    private String kichCo;
    private String mauSac;
}
