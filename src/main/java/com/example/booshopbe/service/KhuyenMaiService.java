package com.example.booshopbe.service;

import com.example.booshopbe.apirespone.GlobalExceoption;
import com.example.booshopbe.entity.KhuyenMai;
import com.example.booshopbe.entity.KichCo;
import com.example.booshopbe.entity.NhanVien;
import com.example.booshopbe.responsitory.KhuyenMaiResponsitory;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class KhuyenMaiService {

    @Autowired
    KhuyenMaiResponsitory khuyenMaiResponsitory;

    public List<KhuyenMai> getAll(){
        updateExpiredKhuyenMai();
        return khuyenMaiResponsitory.findAll();
    }

    public List<KhuyenMai> getByTrangThai(int trangthai) {
        updateExpiredKhuyenMai();
        return khuyenMaiResponsitory.findByTrangthai(trangthai);
    }
    public KhuyenMai insert(KhuyenMai khuyenMai){
        return khuyenMaiResponsitory.save(khuyenMai);
    }

    public KhuyenMai update(UUID id, KhuyenMai khuyenMai){
        KhuyenMai entity = khuyenMaiResponsitory.findById(id).get();
        if (entity == null){
            throw new GlobalExceoption("Khong tim thay");
        }
        try {
            entity.setMakhuyenmai(khuyenMai.getMakhuyenmai());
            entity.setNgaybatdau(khuyenMai.getNgaybatdau());
            entity.setNgayketthuc(khuyenMai.getNgayketthuc());
            entity.setPhamtramgiam(khuyenMai.getPhamtramgiam());
            entity.setTrangthai(khuyenMai.getTrangthai());
            entity.setDieukien(khuyenMai.getDieukien());
            entity.setSoluong(khuyenMai.getSoluong());
            return khuyenMaiResponsitory.save(entity);
        }catch (Exception ex){
            throw new GlobalExceoption("Fail");
        }
    }

    public KhuyenMai findById (UUID id){
        KhuyenMai khuyenMai = khuyenMaiResponsitory.findById(id).get();
        if (khuyenMai == null){
            throw new GlobalExceoption("Khong tim thay nhan vien");
        }
        return khuyenMai;
    }
    public void deleteById(UUID id) {
        KhuyenMai khuyenMai = khuyenMaiResponsitory.findById(id).get();
        if (khuyenMai == null){
            throw new GlobalExceoption("Khong tim thay");
        }
        khuyenMaiResponsitory.delete(khuyenMai);
    }


    public void updateExpiredKhuyenMai() {
        Date currentDate = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentDate);
        calendar.add(Calendar.DATE, -1); // Trừ đi 1 ngày để lấy ngày hôm qua
        Date yesterday = calendar.getTime();
        List<KhuyenMai> expiredKhuyenMai = khuyenMaiResponsitory.findByNgayketthucBefore(yesterday);
        for (KhuyenMai km : expiredKhuyenMai) {
            km.setTrangthai(0); // Giả sử 0 là trạng thái không hiệu lực
            khuyenMaiResponsitory.save(km);
        }
    }

}
