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
@Table(name = "MauSac")
public class MauSac {
    @Id
    @Column(name = "IdMauSac")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idMauSac;

    @Column(name = "TenMauSac")
    private String tenmausac;

    @Column(name = "TrangThai")
    private int trangthai;
}
