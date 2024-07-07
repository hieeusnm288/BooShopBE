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
@Table(name = "NhanVien")
public class NhanVien {
    @Id
    @Column(name = "IdNhanVien")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idNhanVien;

    @Column(name = "ChucVu")
    private int chucvu;

    @Column(name = "TenNhanVien")
    private String tennhanvien;

    @Column(name = "UserName")
    private String username;

    @Column(name = "PassWord")
    private String password;

    @Column(name = "GioiTinh")
    private int gioitinh;

    @Column(name = "SoDienThoai")
    private String sodienthoai;

    @Column(name = "Email")
    private String email;

    @Column(name = "DiaChi")
    private String diachi;

    @Column(name = "NgaySinh")
    private Date ngaysinh;

    @Column(name = "HinhAnh")
    private String hinhanh;

    @Column(name = "TrangThai")
    private int trangthai;
}
