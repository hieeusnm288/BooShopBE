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
@Table(name = "ThuongHieu")
public class ThuongHieu {
    @Id
    @Column(name = "IdThuongHieu")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idThuongHieu;

    @Column(name = "TenThuongHieu")
    private String tenthuonghieu;

    @Column(name = "MoTa")
    private String mota;

    @Column(name = "HinhAnh")
    private String hinhanh;

    @Column(name = "TrangThai")
    private int trangthai;

}
