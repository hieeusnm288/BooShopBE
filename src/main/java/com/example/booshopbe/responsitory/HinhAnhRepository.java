package com.example.booshopbe.responsitory;

import com.example.booshopbe.entity.HinhAnh;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HinhAnhRepository extends JpaRepository<HinhAnh, UUID> {
    List<HinhAnh> findByChitietsanpham_IdChiTietSanPham(UUID idChiTietSanPham);



}
