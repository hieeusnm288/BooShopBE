package com.example.booshopbe.responsitory;

import com.example.booshopbe.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface NhanVienResponsitory extends JpaRepository<NhanVien, UUID> {

    Page<NhanVien> findByUsernameContainsIgnoreCase(String username, Pageable pageable);

    List<NhanVien> findNhanVienByEmailContainsIgnoreCase(String email);

    List<NhanVien> findNhanVienBySodienthoaiContainsIgnoreCase(String sodienthoai);

    List<NhanVien> findNhanVienByUsernameContainsIgnoreCase(String username);

    public NhanVien findNhanVienByUsername(String username);

}
