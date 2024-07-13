package com.example.booshopbe.service;

import com.example.booshopbe.entity.KhachHang;
import com.example.booshopbe.entity.NhanVien;
import com.example.booshopbe.responsitory.KhachHangResponsitory;
import com.example.booshopbe.responsitory.NhanVienResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AccountServiceImpl implements AccountService{

    @Autowired
    private KhachHangResponsitory khachHangResponsitory;

    @Autowired
    public AccountServiceImpl(KhachHangResponsitory khachHangResponsitory) {
        this.khachHangResponsitory = khachHangResponsitory;
    }

    @Override
    public KhachHang findKhachHangByUsername(String username) {
        return khachHangResponsitory.findKhachHangByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        KhachHang khachHang = findKhachHangByUsername(username);
        if (khachHang == null) {
            throw new RuntimeException("Khong ton tai nhan vien");
        }

        String username1 = khachHang.getUsername();
        String password = khachHang.getPassword();
        String chucvu = "khachhang";
        if (username1 == null || password == null) {
            throw new RuntimeException("Khong hop le");
        }
        System.out.println(chucvu);
        return new User(username, password, Collections.singletonList(new SimpleGrantedAuthority(chucvu)));
    }
}
