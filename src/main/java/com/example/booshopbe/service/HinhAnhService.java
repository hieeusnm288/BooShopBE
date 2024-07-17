package com.example.booshopbe.service;

import com.example.booshopbe.dto.HinhAnhDTO;
import com.example.booshopbe.entity.ChiTietSanPham;
import com.example.booshopbe.entity.HinhAnh;
import com.example.booshopbe.responsitory.ChiTietSanPhamReposotory;
import com.example.booshopbe.responsitory.HinhAnhRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HinhAnhService {

    @Autowired
    HinhAnhRepository hinhAnhRepository;

    @Autowired
    ChiTietSanPhamReposotory chiTietSanPhamReposotory;

    @Autowired
    FileStorageService fileStorageService;

    public List<HinhAnh> getListByCTSP(UUID id){
        return hinhAnhRepository.findByChitietsanpham_IdChiTietSanPham(id);
    }

    public HinhAnh insert(HinhAnhDTO hinhAnhDTO){
        HinhAnh entity = new HinhAnh();
        ChiTietSanPham chiTietSanPham = chiTietSanPhamReposotory.findById(hinhAnhDTO.getIdChiTietSanPham()).get();
        BeanUtils.copyProperties(hinhAnhDTO, entity);
        entity.setChitietsanpham(chiTietSanPham);
        if (hinhAnhDTO.getLogoFile() != null) {
            String filename = fileStorageService.storeLogoFile(hinhAnhDTO.getLogoFile());
            entity.setTenhinhanh(filename);
            hinhAnhDTO.setLogoFile(null);
        }
        return hinhAnhRepository.save(entity);
    }
}
