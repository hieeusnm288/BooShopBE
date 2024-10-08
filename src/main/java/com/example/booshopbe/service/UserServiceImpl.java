package com.example.booshopbe.service;

import com.example.booshopbe.apirespone.GlobalExceoption;
import com.example.booshopbe.entity.KhachHang;
import com.example.booshopbe.entity.NhanVien;
import com.example.booshopbe.responsitory.KhachHangResponsitory;
import com.example.booshopbe.responsitory.NhanVienResponsitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private NhanVienResponsitory nhanVienResponsitory;

    @Autowired KhachHangResponsitory khachHangResponsitory;

    @Autowired
    public UserServiceImpl(NhanVienResponsitory nhanVienResponsitory) {
        this.nhanVienResponsitory = nhanVienResponsitory;
    }

    @Override
    public NhanVien findNhanVienByUsername(String username) {
        return nhanVienResponsitory.findNhanVienByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        NhanVien nhanVien = findNhanVienByUsername(username);
        KhachHang khachHang = khachHangResponsitory.findKhachHangByUsername(username);
        if (nhanVien == null && khachHang == null) {
            throw new RuntimeException("Lỗi");
        }
        if (nhanVien != null){
            String username1 = nhanVien.getUsername();
            String password = nhanVien.getPassword();
            String chucvu = "khachhang";
            if (username1 == null || password == null) {
                throw new RuntimeException("Khong hop le");
            }
            int role = nhanVien.getChucvu();
            if (role == 0) {
                chucvu = "Chua gan chuc vu";
                throw new IllegalStateException("Tài khoản không có vai trò nào được gán");
            }
            if (role == 1){
                chucvu = "user";
            }
            if (role ==2){
                chucvu = "admin";
            }

            return new User(username, password, Collections.singletonList(new SimpleGrantedAuthority(chucvu)));
        }else{
            String username1 = khachHang.getUsername();
            String password = khachHang.getPassword();
            String chucvu = "khachhang";
            if (username1 == null || password == null) {
                throw new GlobalExceoption("Khong hop le");
            }
            return new User(username, password, Collections.singletonList(new SimpleGrantedAuthority(chucvu)));
        }


    }
//    private Collection<? extends GrantedAuthority> roleToAuthorities(Collection<NhanVien> nhanViens) {
//
//        Role role = roles.iterator().next(); // Lấy vai trò đầu tiên
//        String roleName = role.getRoleName();
//        Objects.requireNonNull(roleName, "Tên vai trò không thể là null");
//        return Collections.singletonList(new SimpleGrantedAuthority(roleName));
//    }
}
