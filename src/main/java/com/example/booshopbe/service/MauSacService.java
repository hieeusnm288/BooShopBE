package com.example.booshopbe.service;


import com.example.booshopbe.apirespone.GlobalExceoption;
import com.example.booshopbe.entity.KhuyenMai;
import com.example.booshopbe.entity.MauSac;
import com.example.booshopbe.entity.PhuongThucThanhToan;
import com.example.booshopbe.responsitory.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MauSacService {
    @Autowired
    MauSacRepository mauSacRepository;

    public List<MauSac> getAll(){
        return mauSacRepository.findAll();
    }

    public MauSac insert(MauSac mauSac){
        return mauSacRepository.save(mauSac);
    }

    public MauSac update(UUID id, MauSac mauSac){
        MauSac entity = mauSacRepository.findById(id).get();
        if (entity == null){
            throw new GlobalExceoption("Khong tim thay");
        }
        try {
            entity.setTenmausac(mauSac.getTenmausac());
            entity.setTrangthai(mauSac.getTrangthai());
            return mauSacRepository.save(entity);
        }catch (Exception ex){
            throw new GlobalExceoption("Fail");
        }
    }

    public MauSac findById (UUID id){
        MauSac mauSac = mauSacRepository.findById(id).get();
        if (mauSac == null){
            throw new GlobalExceoption("Khong tim thay nhan vien");
        }
        return mauSac;
    }

    public void deleteById(UUID id) {
        MauSac mauSac = mauSacRepository.findById(id).get();
        if (mauSac == null){
            throw new GlobalExceoption("Khong tim thay");
        }
        mauSacRepository.delete(mauSac);
    }

    public MauSac findByName(String name){
        return mauSacRepository.findByTenmausac(name);
    }
}
