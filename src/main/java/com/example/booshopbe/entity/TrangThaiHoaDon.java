package com.example.booshopbe.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TrangThaiHoaDon")
public class TrangThaiHoaDon {
    @Id
    @Column(name = "IdTrangThaiHoaDon")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int IdTrangThaiHoaDon;

    @Column(name = "TenTrangThai")
    private String tentrangthai;
}
