package com.example.booshopbe.controller;

import com.example.booshopbe.apirespone.ApiRespone;
import com.example.booshopbe.dto.GioHangDTO;
import com.example.booshopbe.entity.GioHang;
import com.example.booshopbe.entity.SanPham;
import com.example.booshopbe.service.GioHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/giohang")
public class GioHangController {
    @Autowired
    GioHangService gioHangService;

    @PostMapping("/add")
    public ApiRespone<GioHang> insert(@RequestBody GioHangDTO gioHangDTO){
        ApiRespone apiRespone = new ApiRespone();
        GioHang gioHang = gioHangService.insert(gioHangDTO);
        gioHangDTO.setIdGioHang(gioHang.getIdGioHang());
        apiRespone.setResult(gioHangDTO);
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @GetMapping("/find")
    public ApiRespone<GioHang> getByUsername(@RequestParam(required = false) String username){
        ApiRespone apiRespone = new ApiRespone();
        GioHang gioHang = gioHangService.getByUsernameKhachHang(username);
        apiRespone.setResult(gioHang);
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }
}
