package com.example.booshopbe.service;

import com.example.booshopbe.entity.NhanVien;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    public NhanVien findNhanVienByUsername(String username);
}
