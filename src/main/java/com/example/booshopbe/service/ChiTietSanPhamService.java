package com.example.booshopbe.service;

import com.example.booshopbe.apirespone.GlobalExceoption;
import com.example.booshopbe.dto.ChiTietSanPhamDTO;
import com.example.booshopbe.dto.ChiTietSanPhamProjection;
import com.example.booshopbe.entity.*;
import com.example.booshopbe.responsitory.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ChiTietSanPhamService {
    @Autowired
    ChiTietSanPhamReposotory chiTietSanPhamReposotory;

    @Autowired
    DeGiayRepository deGiayRepository;

    @Autowired
    KichCoService kichCoService;

    @Autowired
    MauSacRepository mauSacRepository;

    @Autowired
    SanPhamRepository sanPhamRepository;

    public List<ChiTietSanPhamProjection> getChiSanPhamBySanPhamId(UUID idSanPham){
        return chiTietSanPhamReposotory.findBySanpham_IdSanPham(idSanPham);
    }

    public ChiTietSanPham insert(ChiTietSanPhamDTO chiTietSanPhamDTO){
        ChiTietSanPham entity = new ChiTietSanPham();
        BeanUtils.copyProperties(chiTietSanPhamDTO, entity);
        Date date = new Date();
        DeGiay deGiay = deGiayRepository.findById(chiTietSanPhamDTO.getIdDeGiay()).get();
        KichCo kichCo = kichCoService.findById(chiTietSanPhamDTO.getIdKichCo());
        MauSac mauSac = mauSacRepository.findById(chiTietSanPhamDTO.getIdMauSac()).get();
        SanPham sanPham = sanPhamRepository.findById(chiTietSanPhamDTO.getIdSanPham()).get();
        entity.setSanpham(sanPham);
        entity.setMausac(mauSac);
        entity.setKichco(kichCo);
        entity.setDegiay(deGiay);
        entity.setNgaytao(date);
        return chiTietSanPhamReposotory.save(entity);
    }

    public ChiTietSanPham update(UUID id, ChiTietSanPhamDTO chiTietSanPhamDTO){
        System.out.println("id: "+ id);
        ChiTietSanPham entity = chiTietSanPhamReposotory.findById(id).get();
        if (entity == null){
            throw new GlobalExceoption("Khong tim thay");
        }
        Date date = new Date();
        BeanUtils.copyProperties(chiTietSanPhamDTO, entity);
        entity.setIdChiTietSanPham(id);
        entity.setSanpham(entity.getSanpham());
        entity.setMausac(entity.getMausac());
        entity.setKichco(entity.getKichco());
        entity.setDegiay(entity.getDegiay());
        entity.setNgaytao(date);
        return chiTietSanPhamReposotory.save(entity);
    }

    public ChiTietSanPham getCTSPbySP_KT_MS(UUID idSanPham, UUID idMauSac,UUID idKichThuoc){

        return chiTietSanPhamReposotory.findBySanpham_IdSanPhamAndKichco_IdKichCoAndMausac_IdMauSac(idSanPham,idKichThuoc,idMauSac);
    }


}
