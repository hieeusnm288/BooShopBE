package com.example.booshopbe.service;

import com.example.booshopbe.dto.DiaChiDTO;
import com.example.booshopbe.entity.DiaChi;
import com.example.booshopbe.entity.KhachHang;
import com.example.booshopbe.responsitory.DiaChiRepository;
import com.example.booshopbe.responsitory.KhachHangResponsitory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DiaChiService {
    @Autowired
    DiaChiRepository diaChiRepository;

    @Autowired
    KhachHangResponsitory khachHangResponsitory;
    public List<DiaChi> getListDiaChi(UUID id){
        return diaChiRepository.findByKhachHang_IdKhachHang(id);
    }

    public DiaChi insert(DiaChiDTO dto){
        DiaChi entity = new DiaChi();
        KhachHang khachHang = khachHangResponsitory.findById(dto.getIdKhachHang()).get();
        BeanUtils.copyProperties(dto, entity);
        entity.setKhachHang(khachHang);
        return diaChiRepository.save(entity);
    }

    public DiaChi update(UUID id,DiaChiDTO dto){
        DiaChi diaChi = diaChiRepository.findById(id).get();
        if (diaChi == null){
            throw new RuntimeException("Khong tim thay");
        }
        DiaChi entity = new DiaChi();
        BeanUtils.copyProperties(dto, entity);
        entity.setIdDiaChi(diaChi.getIdDiaChi());
        entity.setKhachHang(diaChi.getKhachHang());
        return diaChiRepository.save(entity);
    }

    public void delete(UUID id){
        DiaChi diaChi = diaChiRepository.findById(id).get();
        if (diaChi == null){
            throw new RuntimeException("Khong tim thay");
        }
        diaChiRepository.deleteById(id);
    }
}
