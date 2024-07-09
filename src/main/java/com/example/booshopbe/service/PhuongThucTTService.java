package com.example.booshopbe.service;

import com.example.booshopbe.entity.PhuongThucThanhToan;
import com.example.booshopbe.responsitory.HinhThucThanhToanRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
            throw new RuntimeException("Khong tim thay");
        }
        try {
//            category.setId(id);
            pttt.setHinhthuc(phuongThucThanhToan.getHinhthuc());
            return respository.save(pttt);
        }catch (Exception ex){
            throw new RuntimeException("Fail");
        }
    }

    public void deleteById(int id) {
        PhuongThucThanhToan pttt = respository.findById(id).get();
        if (pttt == null){
            throw new RuntimeException("Khong tim thay");
        }
        respository.delete(pttt);
    }

}
