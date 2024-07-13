package com.example.booshopbe.service;


import com.example.booshopbe.entity.KhachHang;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AccountService extends UserDetailsService {
    public KhachHang findKhachHangByUsername(String username);
}
