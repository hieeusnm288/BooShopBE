package com.example.booshopbe.security;


public class Endpoints {
    public static final String front_end_host = "http://localhost:3000";

//    public static final String front_end_host = "https://myprojectfe.vercel.app";
    public static final String[] PUBLIC_GET_ENDPOINS = {
            "/api/v1/product/**",
            "/api/v1/category/**",
//            "/api/v1/nhanvien/**",
    };

    public static final String[] PUBLIC_POST_ENDPOINS = {
            "/api/v1/nhanvien/login",
    };

    public static final String[] ADMIN_GET_ENDPOINS = {
            "/api/v1/nhanvien/**",
            "/api/v1/order_detail/{id}",
            "/api/v1/order/**",
            "/api/v1/product/{id}",
            "/api/v1/brand/{id}",
    };

    public static final String[] ADMIN_POST_ENDPOINS = {
            "/api/v1/brand",
            "/api/v1/product",
            "/api/v1/nhanvien/add",
            "/api/v1/order"
    };

    public static final String[] ADMIN_PUT_ENDPOINS = {
            "/api/v1/brand/{id}",
            "/api/v1/category/{id}",
            "/api/v1/product/{id}",
            "/api/v1/order/{id}",
            "/api/v1/order/cancel/{id}",
            "/api/v1/nhanvien/**",
    };

    public static final String[] ADMIN_DELETE_ENDPOINS = {
            "/api/v1/brand/{id}",
            "/api/v1/category/{id}",
            "/api/v1/product/{id}",
            "/api/v1/nhanvien/**",

    };



    public static final String[] GUEST_GET_ENDPOINS = {
            "/api/v1/account/{id}",
            "/api/v1/order_detail/{id}",
            "/api/v1/order/**"
    };
    public static final String[] GUEST_POST_ENDPOINS = {
            "/api/v1/order",

    };
}