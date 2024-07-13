package com.example.booshopbe.service;

import com.example.booshopbe.entity.NhanVien;
import com.example.booshopbe.responsitory.NhanVienResponsitory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.UUID;

@Service
public class NhanVienService {
    @Autowired
    NhanVienResponsitory nhanVienResponsitory;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<NhanVien> getAll() {
        return nhanVienResponsitory.findAll();
    }

    public NhanVien insert(NhanVien nhanVien) {
        List<?> foundedListEmail = nhanVienResponsitory.findNhanVienByEmailContainsIgnoreCase(nhanVien.getEmail());
        List<?> foundedListPhone = nhanVienResponsitory.findNhanVienBySodienthoaiContainsIgnoreCase(nhanVien.getSodienthoai());
        List<?> foundedListUsername = nhanVienResponsitory.findNhanVienByUsernameContainsIgnoreCase(nhanVien.getUsername());
        if (foundedListEmail.size() > 0) {
            throw new RuntimeException("Email đã được sử dụng");
        }
        if (foundedListPhone.size() > 0) {
            throw new RuntimeException("Số điện thoại đã được sử dụng");
        }
        if (foundedListUsername.size() > 0) {
            throw new RuntimeException("Username đã được sử dụng");
        }
        NhanVien nhanVien1 = new NhanVien();
        BeanUtils.copyProperties(nhanVien, nhanVien1);
        String encryptPassword = passwordEncoder.encode(nhanVien.getPassword());
        nhanVien1.setPassword(encryptPassword);
        return nhanVienResponsitory.save(nhanVien1);
    }

    public NhanVien findByUsername(String username) {
        NhanVien nhanVien = nhanVienResponsitory.findNhanVienByUsername(username);
        if (nhanVien == null) {
            throw new RuntimeException("Khong tim thay nhan vien");
        }
        return nhanVien;
    }

    public NhanVien findById(UUID id) {
        NhanVien nhanVien = nhanVienResponsitory.findById(id).get();
        if (nhanVien == null) {
            throw new RuntimeException("Khong tim thay nhan vien");
        }
        return nhanVien;
    }

    public NhanVien updateNhanhVien(UUID id, NhanVien nhanVien) {
        NhanVien nhanVien1 = nhanVienResponsitory.findById(id).get();
        if (nhanVien1 == null) {
            throw new RuntimeException("Khong tim thay account");
        }
        try {
            nhanVien1.setUsername(nhanVien1.getUsername());
            nhanVien1.setPassword(nhanVien1.getPassword());
            nhanVien1.setTennhanvien(nhanVien.getTennhanvien());
            nhanVien1.setChucvu(nhanVien.getChucvu());
            nhanVien1.setGioitinh(nhanVien.getGioitinh());
            nhanVien1.setSodienthoai(nhanVien.getSodienthoai());
            nhanVien1.setEmail(nhanVien.getEmail());
            nhanVien1.setDiachi(nhanVien.getDiachi());
            nhanVien1.setNgaysinh(nhanVien.getNgaysinh());
            nhanVien1.setHinhanh(nhanVien.getHinhanh());
            nhanVien1.setTrangthai(nhanVien.getTrangthai());
            nhanVienResponsitory.save(nhanVien1);
            return nhanVien1;
        } catch (Exception e) {
            throw new RuntimeException("Loi");
        }
    }

    public void deleteNhanVien(UUID id) {
        NhanVien nhanVien = nhanVienResponsitory.findById(id).get();
        if (nhanVien == null) {
            throw new RuntimeException("Khong tim thay account");
        }
        nhanVienResponsitory.deleteById(id);
    }
}
