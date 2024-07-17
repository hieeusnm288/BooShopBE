package com.example.booshopbe.dto;

import com.example.booshopbe.entity.DeGiay;
import com.example.booshopbe.entity.KichCo;
import com.example.booshopbe.entity.MauSac;
import com.example.booshopbe.entity.ThuongHieu;

import java.util.UUID;

public interface ChiTietSanPhamProjection {
    UUID getIdChiTietSanPham();
    String getTrangthai();
    String getMota();
    KichCo getKichco();
    MauSac getMausac();
    DeGiay getDegiay();
    int getSoluongton();
    double getDongia();
    String getTenhinhanh();

}
