package com.example.booshopbe.responsitory;

import com.example.booshopbe.entity.GioHangChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface GioHangChiTietRepository extends JpaRepository<GioHangChiTiet, UUID> {
    List<GioHangChiTiet> findByGioHang_IdGioHang(UUID IdGioHang);

    public GioHangChiTiet findByGioHang_IdGioHangAndChiTietSanPham_idChiTietSanPham(UUID IdGioHang, UUID idChiTietSanPham);
//    @Query("DELETE from GioHangChiTiet where gioHang.idGioHang = ?1")
//    public void deleteAllByGioHang_IdGioHang(UUID id);
    void deleteByGioHang_IdGioHang(UUID gioHangId);

}
