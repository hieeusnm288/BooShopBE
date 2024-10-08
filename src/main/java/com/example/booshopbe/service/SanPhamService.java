package com.example.booshopbe.service;

import com.example.booshopbe.apirespone.GlobalExceoption;
import com.example.booshopbe.dto.SanPhamDTO;
import com.example.booshopbe.dto.SanPhamProjection;
import com.example.booshopbe.entity.SanPham;
import com.example.booshopbe.entity.ThuongHieu;
import com.example.booshopbe.responsitory.SanPhamRepository;
import com.example.booshopbe.responsitory.ThuongHieuResponsitory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class SanPhamService {
    @Autowired
    SanPhamRepository sanPhamRepository;

    @Autowired
    ThuongHieuResponsitory thuongHieuResponsitory;

    public Page<SanPhamProjection> getAll(Pageable pageable) {
        return sanPhamRepository.getList(pageable);
    }

    public Page<SanPhamProjection> getByTrangThai(String tensanpham, Integer trangthai, String id, Pageable pageable) {

        if (tensanpham != null && !tensanpham.isEmpty()) {
            return sanPhamRepository.getListByTen(tensanpham, pageable);
        } else if ( id != null && !id.isEmpty()) {
            UUID uuid = UUID.fromString(id);
            return sanPhamRepository.getListByBrand(uuid, pageable);
        } else if (trangthai == 0 || trangthai == 1) {
            return sanPhamRepository.getListByStatus(trangthai, pageable);
        } else {
            return sanPhamRepository.getList(pageable);
        }
    }

    public SanPham insert(SanPhamDTO sanPhamDTO){
        SanPham entity = new SanPham();
        Date date = new Date();
        BeanUtils.copyProperties(sanPhamDTO, entity);
        ThuongHieu thuongHieu = thuongHieuResponsitory.findById(sanPhamDTO.getIdThuongHieu()).get();
        entity.setNgaytao(date);
        entity.setThuonghieu(thuongHieu);
        return sanPhamRepository.save(entity);
    }

    public SanPham update(UUID id,SanPhamDTO sanPhamDTO){
        SanPham entity = sanPhamRepository.findById(id).get();
        if (entity == null){
            throw new GlobalExceoption("Khong tim thay san pham");
        }
        ThuongHieu thuongHieu = thuongHieuResponsitory.findById(sanPhamDTO.getIdThuongHieu()).get();
        entity.setTensanpham(sanPhamDTO.getTensanpham());
        entity.setMota(sanPhamDTO.getMota());
        entity.setTrangthai(sanPhamDTO.getTrangthai());
        entity.setThuonghieu(thuongHieu);
        entity.setNgaytao(entity.getNgaytao());
        return sanPhamRepository.save(entity);
    }

    public SanPham getById(UUID id){
        SanPham entity = sanPhamRepository.findById(id).get();
        if (entity.getIdSanPham() == null) {
            throw new GlobalExceoption("Khong tim thay");
        }
        return entity;
    }
}
