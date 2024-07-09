package com.example.booshopbe.responsitory;

import com.example.booshopbe.entity.PhuongThucThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HinhThucThanhToanRespository extends JpaRepository<PhuongThucThanhToan, Integer> {

}
