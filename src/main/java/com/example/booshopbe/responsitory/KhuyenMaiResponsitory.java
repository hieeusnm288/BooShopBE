package com.example.booshopbe.responsitory;

import com.example.booshopbe.entity.KhuyenMai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface KhuyenMaiResponsitory extends JpaRepository<KhuyenMai, UUID> {
    List<KhuyenMai> findByNgayketthucBefore(Date ngayketthuc);

    List<KhuyenMai> findByTrangthai(int trangthai);




}
