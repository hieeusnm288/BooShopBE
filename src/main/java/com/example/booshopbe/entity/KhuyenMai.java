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
@Table(name = "KhuyenMai")
public class KhuyenMai {
    @Id
    @Column(name = "IdKhuyenMai")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idKhuyenMai;

    @Column(name = "MaKhuyenMai")
    private String makhuyenmai;

    @Column(name = "PhanTramGiam")
    private int phamtramgiam;

    @Column(name = "NgayBatDau")
    private Date ngaybatdau;

    @Column(name = "NgayKetThuc")
    private Date ngayketthuc;

    @Column(name = "DieuKien")
    private int dieukien;

    @Column(name = "SoLuong")
    private int soluong;

    @Column(name = "TrangThai")
    private int trangthai;
}
