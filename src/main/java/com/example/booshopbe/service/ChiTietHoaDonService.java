package com.example.booshopbe.service;

import com.example.booshopbe.dto.ChiTietHoaDonDTO;
import com.example.booshopbe.entity.ChiTietHoaDon;
import com.example.booshopbe.entity.ChiTietSanPham;
import com.example.booshopbe.entity.HoaDon;
import com.example.booshopbe.responsitory.ChiTietHoaDonRepository;
import com.example.booshopbe.responsitory.ChiTietSanPhamReposotory;
import com.example.booshopbe.responsitory.HoaDonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChiTietHoaDonService {
    @Autowired
    ChiTietHoaDonRepository chiTietHoaDonRepository;

    @Autowired
    HoaDonRepository hoaDonRepository;

    @Autowired
    ChiTietSanPhamReposotory chiTietSanPhamReposotory;

    public List<ChiTietHoaDon> getList(UUID idHoaDon){
        return chiTietHoaDonRepository.findByHoaDon_IdHoaDon(idHoaDon);
    }

    public ChiTietHoaDon insert(ChiTietHoaDonDTO chiTietHoaDonDTO){
        ChiTietHoaDon entity = new ChiTietHoaDon();
        HoaDon hoaDon = hoaDonRepository.findById(chiTietHoaDonDTO.getIdHoaDon()).get();
        ChiTietSanPham chiTietSanPham = chiTietSanPhamReposotory.findById(chiTietHoaDonDTO.getIdChiTietSanPham()).get();
        BeanUtils.copyProperties(chiTietHoaDonDTO, entity);
        entity.setHoaDon(hoaDon);
        entity.setChiTietSanPham(chiTietSanPham);
        return chiTietHoaDonRepository.save(entity);
    }

}
