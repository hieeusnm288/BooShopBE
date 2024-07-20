package com.example.booshopbe.service;

import com.example.booshopbe.dto.HoaDonDTO;
import com.example.booshopbe.entity.*;
import com.example.booshopbe.responsitory.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class HoaDonService {
    @Autowired
    HoaDonRepository hoaDonRepository;

    @Autowired
    KhachHangResponsitory khachHangResponsitory;

    @Autowired
    TrangThaiHoaDonRepository trangThaiHoaDonRepository;

    @Autowired
    HinhThucThanhToanRespository hinhThucThanhToanRespository;

    @Autowired
    KhuyenMaiResponsitory khuyenMaiResponsitory;

    public List<HoaDon> getAll() {
        return hoaDonRepository.findAll();
    }

    public List<HoaDon> getByKhachHang(UUID id) {
        return hoaDonRepository.findByKhachHang_IdKhachHang(id);
    }

    public HoaDon insert(HoaDonDTO hoaDonDTO){
        HoaDon entity = new HoaDon();
        Date date = new Date();

        KhachHang khachHang = khachHangResponsitory.findById(hoaDonDTO.getIdKhachHang()).get();
        if (hoaDonDTO.getIdKhuyenMai() != null){
            UUID uuid = UUID.fromString(hoaDonDTO.getIdKhuyenMai());
            KhuyenMai khuyenMai = khuyenMaiResponsitory.findById(uuid).get();
            entity.setKhuyenMai(khuyenMai);
        }else {
            entity.setKhuyenMai(null);
        }
        TrangThaiHoaDon trangThaiHoaDon = trangThaiHoaDonRepository.findById(hoaDonDTO.getIdTrangThaiDonHang()).get();
        PhuongThucThanhToan phuongThucThanhToan = hinhThucThanhToanRespository.findById(hoaDonDTO.getIdPhuongThucThanhToan()).get();
        BeanUtils.copyProperties(hoaDonDTO, entity);
        entity.setNgaytao(date);
        entity.setKhachHang(khachHang);
        entity.setTrangThaiHoaDon(trangThaiHoaDon);
        entity.setPhuongThucThanhToan(phuongThucThanhToan);
        return hoaDonRepository.save(entity);
    }

    public HoaDon update(UUID id, HoaDonDTO hoaDonDTO){
        HoaDon entity = hoaDonRepository.findById(id).get();
        if (entity == null){
            throw new RuntimeException("Khong tim thay san pham");
        }
        TrangThaiHoaDon trangThaiHoaDon = trangThaiHoaDonRepository.findById(hoaDonDTO.getIdTrangThaiDonHang()).get();
        entity.setTrangThaiHoaDon(trangThaiHoaDon);
        return hoaDonRepository.save(entity);
    }
}
