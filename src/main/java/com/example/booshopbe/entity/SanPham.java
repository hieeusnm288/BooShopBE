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
@Table(name = "SanPham")
public class SanPham {
    @Id
    @Column(name = "IdSanPham")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idSanPham;

    @Column(name = "TenSanPham")
    private String tensanpham;

    @Column(name = "NgayTao")
    private Date ngaytao;

    @Column(name = "MoTa")
    private String mota;

    @Column(name = "TrangThai")
    private int trangthai;

    @ManyToOne
    @JoinColumn(name = "ThuongHieuId")
    private ThuongHieu thuonghieu;
}
