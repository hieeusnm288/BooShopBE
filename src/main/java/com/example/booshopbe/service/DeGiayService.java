package com.example.booshopbe.service;

import com.example.booshopbe.apirespone.GlobalExceoption;
import com.example.booshopbe.entity.DeGiay;
import com.example.booshopbe.entity.KichCo;
import com.example.booshopbe.entity.MauSac;
import com.example.booshopbe.responsitory.DeGiayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeGiayService {
    @Autowired
    DeGiayRepository deGiayRepository;
    public List<DeGiay> getAll(){
        return deGiayRepository.findAll();
    }

    public DeGiay insert(DeGiay deGiay){
        return deGiayRepository.save(deGiay);
    }

    public DeGiay update(UUID id, DeGiay deGiay){
        DeGiay entity = deGiayRepository.findById(id).get();
        if (entity == null){
            throw new GlobalExceoption("Khong tim thay");
        }
        try {
            entity.setTendegiay(deGiay.getTendegiay());
            entity.setTrangthai(deGiay.getTrangthai());
            return deGiayRepository.save(entity);
        }catch (Exception ex){
            throw new GlobalExceoption("Fail");
        }
    }

    public DeGiay findById (UUID id){
        DeGiay deGiay = deGiayRepository.findById(id).get();
        if (deGiay == null){
            throw new GlobalExceoption("Khong tim thay nhan vien");
        }
        return deGiay;
    }

    public void deleteById(UUID id) {
        DeGiay deGiay = deGiayRepository.findById(id).get();
        if (deGiay == null){
            throw new GlobalExceoption("Khong tim thay");
        }
        deGiayRepository.delete(deGiay);
    }
}
