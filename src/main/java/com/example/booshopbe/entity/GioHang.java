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
@Table(name = "GioHang")
public class GioHang {
    @Id
    @Column(name = "IdGioHang")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idGioHang;

    @ManyToOne
    @JoinColumn(name = "KhachHangId")
    private KhachHang khachHang;
}
