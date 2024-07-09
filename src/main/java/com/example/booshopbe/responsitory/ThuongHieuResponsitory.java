package com.example.booshopbe.responsitory;

import com.example.booshopbe.entity.ThuongHieu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ThuongHieuResponsitory extends JpaRepository<ThuongHieu, UUID> {

    List<ThuongHieu> findByTenthuonghieuContainsIgnoreCase(String tenthuonghieu);


}
