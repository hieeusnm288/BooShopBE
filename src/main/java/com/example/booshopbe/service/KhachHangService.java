package com.example.booshopbe.service;

import com.example.booshopbe.entity.KhachHang;
import com.example.booshopbe.entity.NhanVien;
import com.example.booshopbe.responsitory.KhachHangResponsitory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class KhachHangService {
    @Autowired
    KhachHangResponsitory khachHangResponsitory;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public List<KhachHang> getAll() {
        return khachHangResponsitory.findAll();
    }

    public KhachHang insert(KhachHang khachHang) {
        List<?> foundedListEmail = khachHangResponsitory.findKhachHangByEmailContainsIgnoreCase(khachHang.getEmail());
        List<?> foundedListPhone = khachHangResponsitory.findKhachHangBySodienthoaiContainsIgnoreCase(khachHang.getSodienthoai());
        List<?> foundedListUsername = khachHangResponsitory.findKhachHangByUsernameContainsIgnoreCase(khachHang.getUsername());
        if (foundedListEmail.size() > 0) {
            throw new RuntimeException("Email đã được sử dụng");
        }
        if (foundedListPhone.size() > 0) {
            throw new RuntimeException("Số điện thoại đã được sử dụng");
        }
        if (foundedListUsername.size() > 0) {
            throw new RuntimeException("Username đã được sử dụng");
        }
        KhachHang khachHang1 = new KhachHang();
        BeanUtils.copyProperties(khachHang, khachHang1);
        String encryptPassword = passwordEncoder.encode(khachHang.getPassword());
        khachHang1.setPassword(encryptPassword);
        return khachHangResponsitory.save(khachHang1);
    }

    public KhachHang updateKhachHang(UUID id, KhachHang khachHang){
        KhachHang khachHang1 = khachHangResponsitory.findById(id).get();
        if (khachHang1 == null){
            throw new RuntimeException("Khong tim thay khach hang");
        }
        try {
            khachHang1.setUsername(khachHang1.getUsername());
            khachHang1.setPassword(khachHang1.getPassword());
            khachHang1.setTenkhachhang(khachHang.getTenkhachhang());
            khachHang1.setGioitinh(khachHang.getGioitinh());
            khachHang1.setSodienthoai(khachHang.getSodienthoai());
            khachHang1.setEmail(khachHang.getEmail());
            khachHang1.setNgaysinh(khachHang.getNgaysinh());
            khachHang1.setTrangthai(khachHang.getTrangthai());
            khachHangResponsitory.save(khachHang1);
            return khachHang1;
        }catch (Exception e){
            throw new RuntimeException("Loi");
        }
    }

    public KhachHang findById(UUID id) {
        KhachHang khachHang = khachHangResponsitory.findById(id).get();
        if (khachHang == null) {
            throw new RuntimeException("Khong tim thay nhan vien");
        }
        return khachHang;
    }

    public KhachHang findByUsername(String username) {
        KhachHang khachHang = khachHangResponsitory.findKhachHangByUsername(username);
        if (khachHang == null) {
            throw new RuntimeException("Khong tim thay nhan vien");
        }
        return khachHang;
    }

    public void deleteKhachHang(UUID id){
        KhachHang khachHang = khachHangResponsitory.findById(id).get();
        if (khachHang == null){
            throw new RuntimeException("Khong tim thay khach hang");
        }
        khachHangResponsitory.deleteById(id);
    }

}
