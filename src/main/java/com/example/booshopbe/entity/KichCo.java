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
@Table(name = "KichCo")
public class KichCo {
    @Id
    @Column(name = "IdKichCo")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idKichCo;

    @Column(name = "TenKichCo")
    private String tenkichco;

    @Column(name = "MoTa")
    private String mota;

    @Column(name = "TrangThai")
    private int trangthai;
}
