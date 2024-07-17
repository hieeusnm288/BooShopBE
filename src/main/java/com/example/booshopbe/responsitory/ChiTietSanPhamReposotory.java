package com.example.booshopbe.responsitory;

import com.example.booshopbe.entity.ChiTietSanPham;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ChiTietSanPhamReposotory extends JpaRepository<ChiTietSanPham, UUID> {
    List<ChiTietSanPham> findBySanpham_IdSanPham(UUID idSanPham);
    
}
