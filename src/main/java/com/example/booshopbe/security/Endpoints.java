package com.example.booshopbe.security;


public class Endpoints {
    public static final String front_end_host = "http://localhost:3000";

    //    public static final String front_end_host = "https://myprojectfe.vercel.app";
    public static final String[] PUBLIC_GET_ENDPOINS = {
            "/api/v1/product/**",
            "/api/v1/thuonghieu/**",
            "/api/v1/pttt/**",
            "/api/v1/mausac/**",
            "/api/v1/kichco/**",
            "/api/v1/khuyenmai/**",
            "/api/v1/degiay/**",
            "/api/v1/sanpham/**",
            "/api/v1/chitietsanpham/**",
            "/api/v1/hinhanh/**",
            "api/v1/trangthaihoadon/**",
            "api/v1/giohang/**",
            "/api/v1/giohangchitiet/**",
            "/api/v1/diachi/**",
            "/api/v1/khachhang/**"
    };

    public static final String[] PUBLIC_POST_ENDPOINS = {
            "/api/v1/nhanvien/login",
            "/api/v1/khachhang/login",
            "/api/v1/khachhang/**",
            "api/v1/trangthaihoadon/**",
            "api/v1/giohang/**",
            "/api/v1/giohangchitiet/**",
            "/api/v1/diachi/**"
    };

    public static final String[] PUBLIC_PUT_ENDPOINS = {
            "/api/v1/khachhang/**",
            "/api/v1/diachi/**"
    };
    public static final String[] PUBLIC_DELETE_ENDPOINS = {
            "/api/v1/giohangchitiet/**",
            "/api/v1/diachi/**"
    };

    public static final String[] ADMIN_GET_ENDPOINS = {
            "/api/v1/thuonghieu/**",
            "/api/v1/pttt/**",
            "/api/v1/mausac/**",
            "/api/v1/kichco/**",
            "/api/v1/nhanvien/**",
            "/api/v1/degiay/**",
            "/api/v1/order_detail/**",
            "/api/v1/khuyenmai/**",
            "/api/v1/order/**",
            "/api/v1/brand/{id}",
            "/api/v1/khachhang/**"
    };

    public static final String[] ADMIN_POST_ENDPOINS = {
            "/api/v1/nhanvien/**",
            "/api/v1/thuonghieu/**",
            "/api/v1/pttt/**",
            "/api/v1/mausac/**",
            "/api/v1/kichco/**",
            "/api/v1/khuyenmai/**",
            "/api/v1/degiay/**",
            "/api/v1/sanpham/**",
            "/api/v1/chitietsanpham/**",
            "/api/v1/hinhanh/**"

    };

    public static final String[] ADMIN_PUT_ENDPOINS = {
            "/api/v1/nhanvien/**",
            "/api/v1/thuonghieu/**",
            "/api/v1/pttt/**",
            "/api/v1/mausac/**",
            "/api/v1/kichco/**",
            "/api/v1/khuyenmai/**",
            "/api/v1/degiay/**",
            "/api/v1/sanpham/**",
            "/api/v1/chitietsanpham/**"
    };

    public static final String[] ADMIN_DELETE_ENDPOINS = {
            "/api/v1/nhanvien/**",
            "/api/v1/thuonghieu/**",
            "/api/v1/pttt/**",
            "/api/v1/mausac/**",
            "/api/v1/kichco/**",
            "/api/v1/khuyenmai/**",
            "/api/v1/degiay/**",
            "/api/v1/khachhang/**",
            "/api/v1/sanpham/**",
            "/api/v1/chitietsanpham/**"


    };


    public static final String[] USER_GET_ENDPOINS = {
            "/api/v1/account/{id}",
            "/api/v1/order_detail/{id}",
            "/api/v1/order/**",
            "/api/v1/nhanvien/detail/**",
    };
    public static final String[] USER_POST_ENDPOINS = {
            "/api/v1/order",
            "/api/v1/thuonghieu/**",
            "/api/v1/pttt/**",
            "/api/v1/mausac/**",
            "/api/v1/kichco/**",
            "/api/v1/khuyenmai/**",
            "/api/v1/degiay/**"

    };
}
