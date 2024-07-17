package com.example.booshopbe.service;

import com.example.booshopbe.dto.ThuongHieuDTO;
import com.example.booshopbe.entity.ThuongHieu;
import com.example.booshopbe.responsitory.ThuongHieuResponsitory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ThuongHieuService {

    @Autowired
    ThuongHieuResponsitory thuongHieuResponsitory;

    @Autowired
    FileStorageService fileStorageService;

    public ThuongHieu insert(ThuongHieuDTO thuongHieuDTO) {
        List<?> fond = thuongHieuResponsitory.findByTenthuonghieuContainsIgnoreCase(thuongHieuDTO.getTenthuonghieu());
        if (fond.size() > 0) {
            throw new RuntimeException("Đã tồn tại");
        }
        ThuongHieu entity = new ThuongHieu();
        BeanUtils.copyProperties(thuongHieuDTO, entity);
        entity.setTenthuonghieu(thuongHieuDTO.getTenthuonghieu());
        if (thuongHieuDTO.getLogoFile() != null) {
            String filename = fileStorageService.storeLogoFile(thuongHieuDTO.getLogoFile());
            entity.setHinhanh(filename);
            thuongHieuDTO.setLogoFile(null);
        }
        return thuongHieuResponsitory.save(entity);
    }

    public List<ThuongHieu> getAll() {
        return thuongHieuResponsitory.findAll();
    }

    public ThuongHieu findById(UUID id) {
        ThuongHieu entity = thuongHieuResponsitory.findById(id).get();
        if (entity.getIdThuongHieu() == null) {
            throw new RuntimeException("Khong tim thay");
        }
        return entity;
    }

    public void deleteThuongHieu(UUID id) {
        ThuongHieu entity = thuongHieuResponsitory.findById(id).get();
        if (entity.getIdThuongHieu() == null) {
            throw new RuntimeException("Khong tim thay");
        } else {
            thuongHieuResponsitory.deleteById(id);
        }
    }

    public ThuongHieu update(UUID id,ThuongHieuDTO dto) {
        ThuongHieu thuongHieu = thuongHieuResponsitory.findById(id).get();
        if (thuongHieu.getIdThuongHieu() == null) {
            throw new RuntimeException("Khong Tim Thay");
        }
        ThuongHieu entity = new ThuongHieu();
        BeanUtils.copyProperties(dto, entity);
        entity.setIdThuongHieu(thuongHieu.getIdThuongHieu());
        if (dto.getLogoFile() != null) {
            String filename = fileStorageService.storeLogoFile(dto.getLogoFile());
            if (filename != null) {
                entity.setHinhanh(filename);
            }
            dto.setLogoFile(null);
        } else {
            entity.setHinhanh(thuongHieu.getHinhanh());
        }
        return thuongHieuResponsitory.save(entity);
    }
}
