package com.example.booshopbe.responsitory;

import com.example.booshopbe.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface KhachHangResponsitory extends JpaRepository<KhachHang, UUID> {
    List<KhachHang> findAll(Sort sort);

    Page<KhachHang> findByUsernameContainsIgnoreCase(String username, Pageable pageable);

    List<KhachHang> findKhachHangByEmailContainsIgnoreCase(String email);

    List<KhachHang> findKhachHangBySodienthoaiContainsIgnoreCase(String sodienthoai);

    List<KhachHang> findKhachHangByUsernameContainsIgnoreCase(String username);

    public KhachHang findKhachHangByUsername(String username);

    @Query(value = "SELECT COUNT(*) FROM KhachHang", nativeQuery = true)
    int findTongSoKhachHang();
}
