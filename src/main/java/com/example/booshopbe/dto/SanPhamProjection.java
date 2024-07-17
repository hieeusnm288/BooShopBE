package com.example.booshopbe.dto;

import com.example.booshopbe.entity.DeGiay;
import com.example.booshopbe.entity.KichCo;
import com.example.booshopbe.entity.MauSac;
import com.example.booshopbe.entity.ThuongHieu;

import java.util.UUID;

public interface SanPhamProjection {
    UUID getIdSanPham();
    String getTensanpham();
    String getTrangthai();
    String getMota();
    UUID getIdChiTietSanPham();
    ThuongHieu getThuonghieu();
    KichCo getKichco();
    MauSac getMausac();
    DeGiay getDegiay();
    int getSoluongton();
    double getDongia();
    String getTenhinhanh();
}
