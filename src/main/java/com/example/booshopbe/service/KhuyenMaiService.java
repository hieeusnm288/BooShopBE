package com.example.booshopbe.service;

import com.example.booshopbe.entity.KhuyenMai;
import com.example.booshopbe.entity.KichCo;
import com.example.booshopbe.entity.NhanVien;
import com.example.booshopbe.responsitory.KhuyenMaiResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KhuyenMaiService {

    @Autowired
    KhuyenMaiResponsitory khuyenMaiResponsitory;

    public List<KhuyenMai> getAll(){
        return khuyenMaiResponsitory.findAll();
    }

    public KhuyenMai insert(KhuyenMai khuyenMai){
        return khuyenMaiResponsitory.save(khuyenMai);
    }

    public KhuyenMai update(UUID id, KhuyenMai khuyenMai){
        KhuyenMai entity = khuyenMaiResponsitory.findById(id).get();
        if (entity == null){
            throw new RuntimeException("Khong tim thay");
        }
        try {
            entity.setMakhuyenmai(khuyenMai.getMakhuyenmai());
            entity.setNgaybatdau(khuyenMai.getNgaybatdau());
            entity.setNgayketthuc(khuyenMai.getNgayketthuc());
            entity.setPhamtramgiam(khuyenMai.getPhamtramgiam());
            entity.setTrangthai(khuyenMai.getTrangthai());
            return khuyenMaiResponsitory.save(entity);
        }catch (Exception ex){
            throw new RuntimeException("Fail");
        }
    }

    public KhuyenMai findById (UUID id){
        KhuyenMai khuyenMai = khuyenMaiResponsitory.findById(id).get();
        if (khuyenMai == null){
            throw new RuntimeException("Khong tim thay nhan vien");
        }
        return khuyenMai;
    }
    public void deleteById(UUID id) {
        KhuyenMai khuyenMai = khuyenMaiResponsitory.findById(id).get();
        if (khuyenMai == null){
            throw new RuntimeException("Khong tim thay");
        }
        khuyenMaiResponsitory.delete(khuyenMai);
    }

}
