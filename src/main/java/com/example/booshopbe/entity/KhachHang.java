package com.example.booshopbe.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name = "KhachHang")
public class KhachHang {
    @Id
    @Column(name = "IdKhachHang")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idKhachHang;

    @Column(name = "TenKhachHang")
    private String tenkhachhang;

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

    @Column(name = "NgaySinh")
    private Date ngaysinh;

    @Column(name = "TrangThai")
    private int trangthai;
}
