package com.example.booshopbe.responsitory;

import com.example.booshopbe.entity.DiaChi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DiaChiRepository extends JpaRepository<DiaChi, UUID> {

    List<DiaChi> findByKhachHang_IdKhachHang(UUID idKhachHang);
}
