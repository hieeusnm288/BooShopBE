package com.example.booshopbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "GioHangChiTiet")
public class GioHangChiTiet {
    @Id
    @Column(name = "IdGioHangChiTiet")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID IdGioHangChiTiet;

    @ManyToOne
    @JoinColumn(name = "GioHangId")
    private GioHang gioHang;

    @ManyToOne
    @JoinColumn(name = "ChiTietSanPhamId")
    private ChiTietSanPham chiTietSanPham;

    @Column(name = "SoLuong")
    private int soluong;

    @Column(name = "TongTien")
    private int tongtien;
}
