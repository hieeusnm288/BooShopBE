package com.example.booshopbe.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HinhAnh")
public class HinhAnh {
    @Id
    @Column(name = "IdHinhAnh")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idHinhAnh;

    @Column(name = "TenHinhAnh")
    private String tenhinhanh;

    @Column(name = "TrangThai")
    private int trangthai;

    @ManyToOne
    @JoinColumn(name = "ChiTietSanPhamId")
    private ChiTietSanPham chitietsanpham;


}
