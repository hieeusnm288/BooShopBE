package com.example.booshopbe.service;

import com.example.booshopbe.entity.KhuyenMai;
import com.example.booshopbe.entity.KichCo;
import com.example.booshopbe.entity.MauSac;
import com.example.booshopbe.responsitory.KichCoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KichCoService {
    @Autowired
    KichCoRepository kichCoRepository;
    public List<KichCo> getAll(){
        return kichCoRepository.findAll();
    }

    public KichCo insert(KichCo kichCo){
        return kichCoRepository.save(kichCo);
    }

    public KichCo update(UUID id, KichCo kichCo){
        KichCo entity = kichCoRepository.findById(id).get();
        if (entity == null){
            throw new RuntimeException("Khong tim thay");
        }
        try {
            entity.setTenkichco(kichCo.getTenkichco());
            entity.setMota(kichCo.getMota());
            entity.setTrangthai(kichCo.getTrangthai());
            return kichCoRepository.save(entity);
        }catch (Exception ex){
            throw new RuntimeException("Fail");
        }
    }
    public KichCo findById (UUID id){
        KichCo kichCo = kichCoRepository.findById(id).get();
        if (kichCo == null){
            throw new RuntimeException("Khong tim thay nhan vien");
        }
        return kichCo;
    }

    public void deleteById(UUID id) {
        KichCo kichCo = kichCoRepository.findById(id).get();
        if (kichCo == null){
            throw new RuntimeException("Khong tim thay");
        }
        kichCoRepository.delete(kichCo);
    }

    public KichCo findByName(String name) {
        return kichCoRepository.findByTenkichco(name);
    }

}
