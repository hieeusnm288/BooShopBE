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
@Table(name = "ChiTietHoaDon")
public class ChiTietHoaDon {
    @Id
    @Column(name = "IdChiTietHoaDon")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idChiTietHoaDon;

    @ManyToOne
    @JoinColumn(name = "HoaDonId")
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "ChiTietSanPhamId")
    private ChiTietSanPham chiTietSanPham;

    @Column(name = "soluong")
    private int soluong;
}
