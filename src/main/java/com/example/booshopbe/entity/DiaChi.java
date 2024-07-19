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
@Table(name = "DiaChi")
public class DiaChi {
    @Id
    @Column(name = "IdDiaChi")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idDiaChi;

    @ManyToOne
    @JoinColumn(name = "KhachHangId")
    private KhachHang khachHang;

    @Column(name = "ThanhPho")
    private String thanhpho;

    @Column(name = "QuanHuyen")
    private String quanhuyen;

    @Column(name = "PhuongXa")
    private String phuongxa;

    @Column(name = "ChiTiet")
    private String chitiet;
}
