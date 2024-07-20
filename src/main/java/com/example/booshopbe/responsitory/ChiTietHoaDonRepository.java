package com.example.booshopbe.responsitory;

import com.example.booshopbe.entity.ChiTietHoaDon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ChiTietHoaDonRepository extends JpaRepository<ChiTietHoaDon, UUID> {
    List<ChiTietHoaDon> findByHoaDon_IdHoaDon(UUID idHoaDon);

}
