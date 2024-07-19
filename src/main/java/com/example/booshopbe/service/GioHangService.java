package com.example.booshopbe.service;

import com.example.booshopbe.dto.GioHangDTO;
import com.example.booshopbe.entity.GioHang;
import com.example.booshopbe.entity.KhachHang;
import com.example.booshopbe.responsitory.GioHangRepository;
import com.example.booshopbe.responsitory.KhachHangResponsitory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GioHangService {
    @Autowired
    GioHangRepository gioHangRepository;

    @Autowired
    KhachHangResponsitory khachHangResponsitory;
    public GioHang insert(GioHangDTO gioHangDTO){
        GioHang entity = new GioHang();
        KhachHang khachHang = khachHangResponsitory.findById(gioHangDTO.getIdKhachHang()).get();
        BeanUtils.copyProperties(gioHangDTO, entity);
        entity.setKhachHang(khachHang);
        return gioHangRepository.save(entity);
    }

    public GioHang getByUsernameKhachHang(String username){
        return gioHangRepository.findByKhachHang_Username(username);
    }
}
