package com.example.booshopbe.service;

import com.example.booshopbe.dto.DoanhThuDTO;
import com.example.booshopbe.dto.DoanhThuProjection;
import com.example.booshopbe.dto.HoaDonDTO;
import com.example.booshopbe.dto.SanPhamThongKe;
import com.example.booshopbe.entity.HoaDon;
import com.example.booshopbe.responsitory.HoaDonRepository;
import com.example.booshopbe.responsitory.KhachHangResponsitory;
import com.example.booshopbe.responsitory.SanPhamRepository;
import jakarta.persistence.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ThongKeService {
    @Autowired
    HoaDonRepository hoaDonRepository;

    @Autowired
    KhachHangResponsitory khachHangResponsitory;

    @Autowired
    SanPhamRepository sanPhamRepository;

    public List<DoanhThuProjection> getRevenueStatisticsForTrangThaiHoaDon() {
    return hoaDonRepository.findMonthlyRevenueWithStatus();
    }

    public int tongHoaDon(int year){
        return hoaDonRepository.countHoaDonByYear(year);
    }

    public int hoaDonHoanThang(int month, int year){
        return hoaDonRepository.countHoaDonByMonth(year , month);
    }

    public int hoaDonHTByYear(int year){
        return hoaDonRepository.countCompletedHoaDonByYear(year);
    }

    public int hoaDonHTByMonth(int year, int month){
        return hoaDonRepository.countCompletedHoaDonByMonth(year,month);
    }

    public List<?> getBestSellingProducts() {
        List<Object[]> results = sanPhamRepository.findBestSellingProducts();
        return results.stream()
                .map(result -> new SanPhamThongKe(
                        (String) result[0],
                        (String) result[1],
                        ((Number) result[2]).intValue(),
                        (String) result[3],
                        (String) result[4]
                ))
                .collect(Collectors.toList());
    }
    public List<?> getNearlyOutOfStockProducts() {
        List<Object[]> results = sanPhamRepository.findNearlyOutOfStockProducts();
        return results.stream()
                .map(result -> new SanPhamThongKe(
                        (String) result[0],
                        (String) result[1],
                        ((Number) result[2]).intValue(),
                        (String) result[3],
                        (String) result[4]
                ))
                .collect(Collectors.toList());
    }

    public int tongKhachHang(){
        return khachHangResponsitory.findTongSoKhachHang();
    }

}
