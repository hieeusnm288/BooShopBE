package com.example.booshopbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ChiTietSanPham")
public class ChiTietSanPham {
    @Id
    @Column(name = "IdChiTietSanPham")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idChiTietSanPham;

    @Column(name = "NgayTao")
    private Date ngaytao;

    @Column(name = "NgaySua")
    private Date ngaysua;

    @Column(name = "DonGia")
    private int dongia;

    @Column(name = "SoLuongTon")
    private int soluongton;

    @Column(name = "TrangThai")
    private int trangthai;

    @ManyToOne
    @JoinColumn(name = "SanPhamId")
    private SanPham sanpham;

    @ManyToOne
    @JoinColumn(name = "DeGiayId")
    private DeGiay degiay;

    @ManyToOne
    @JoinColumn(name = "KichCoId")
    private KichCo kichco;

    @ManyToOne
    @JoinColumn(name = "MauSacId")
    private MauSac mausac;

}
