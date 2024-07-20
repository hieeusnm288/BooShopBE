package com.example.booshopbe.responsitory;

import com.example.booshopbe.entity.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, UUID> {
    List<HoaDon> findByKhachHang_IdKhachHang(UUID idKhachHang);
}
