package com.example.booshopbe.service;

import com.example.booshopbe.apirespone.GlobalExceoption;
import com.example.booshopbe.entity.KhuyenMai;
import com.example.booshopbe.entity.PhuongThucThanhToan;
import com.example.booshopbe.responsitory.HinhThucThanhToanRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PhuongThucTTService {
    @Autowired
    HinhThucThanhToanRespository respository;

    public List<PhuongThucThanhToan> getAll() {
        return respository.findAll();
    }

    public PhuongThucThanhToan insert(PhuongThucThanhToan entity){
        return respository.save(entity);
    }

    public PhuongThucThanhToan update(int id, PhuongThucThanhToan phuongThucThanhToan){
        PhuongThucThanhToan pttt = respository.findById(id).get();
        if (pttt == null){
            throw new GlobalExceoption("Khong tim thay");
        }
        try {
            pttt.setHinhthuc(phuongThucThanhToan.getHinhthuc());
            return respository.save(pttt);
        }catch (Exception ex){
            throw new GlobalExceoption("Fail");
        }
    }
    public PhuongThucThanhToan findById (int id){
        PhuongThucThanhToan phuongThucThanhToan = respository.findById(id).get();
        if (phuongThucThanhToan == null){
            throw new GlobalExceoption("Khong tim thay nhan vien");
        }
        return phuongThucThanhToan;
    }
    public void deleteById(int id) {
        PhuongThucThanhToan pttt = respository.findById(id).get();
        if (pttt == null){
            throw new GlobalExceoption("Khong tim thay");
        }
        respository.delete(pttt);
    }

}
