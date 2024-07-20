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
@Table(name = "HoaDon")
public class HoaDon {
    @Id
    @Column(name = "IdHoaDon")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idHoaDon;

    @ManyToOne
    @JoinColumn(name = "KhachHangId")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "KhuyenMaiId")
    private KhuyenMai khuyenMai;

    @Column(name = "TongTien")
    private int tongtien;

    @Column(name = "NgayTao")
    private Date ngaytao;

    @Column(name = "DiaChi")
    private String diachi;

    @ManyToOne
    @JoinColumn(name = "TrangThaiHoaDon")
    private TrangThaiHoaDon trangThaiHoaDon;

    @ManyToOne
    @JoinColumn(name = "PhuongThucThanhToan")
    private PhuongThucThanhToan phuongThucThanhToan;
}
