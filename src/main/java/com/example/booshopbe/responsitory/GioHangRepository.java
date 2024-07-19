package com.example.booshopbe.responsitory;

import com.example.booshopbe.entity.GioHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface GioHangRepository extends JpaRepository<GioHang, UUID> {
    GioHang findByKhachHang_Username(String username);

}
