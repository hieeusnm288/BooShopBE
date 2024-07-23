package com.example.booshopbe.service;

import com.example.booshopbe.dto.DoanhThuDTO;
import com.example.booshopbe.dto.DoanhThuProjection;
import com.example.booshopbe.dto.HoaDonDTO;
import com.example.booshopbe.entity.HoaDon;
import com.example.booshopbe.responsitory.HoaDonRepository;
import com.example.booshopbe.responsitory.KhachHangResponsitory;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

@Service
public class ThongKeService {
    @Autowired
    HoaDonRepository hoaDonRepository;

    @Autowired
    KhachHangResponsitory khachHangResponsitory;

    public List<DoanhThuProjection> getRevenueStatisticsForTrangThaiHoaDon() {
    return hoaDonRepository.findMonthlyRevenueWithStatus();
    }

    public int tongHoaDon(){
        return hoaDonRepository.findTongSoHoaDonTheoNam();
    }

    public int hoaDonHoanThanh(){
        return hoaDonRepository.findTongSoHoaDonHoanThanhTheoNam();
    }

    public int tongKhachHang(){
        return khachHangResponsitory.findTongSoKhachHang();
    }

}
