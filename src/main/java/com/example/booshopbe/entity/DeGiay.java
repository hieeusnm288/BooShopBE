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
@Table(name = "DeGiay")
public class DeGiay {
    @Id
    @Column(name = "IdDeGiay")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idDeGiay;

    @Column(name = "TenDeGiay")
    private String tendegiay;

    @Column(name = "TrangThai")
    private int trangthai;
}
