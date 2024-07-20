package com.example.booshopbe.controller;

import com.example.booshopbe.apirespone.ApiRespone;
import com.example.booshopbe.dto.ChiTietHoaDonDTO;
import com.example.booshopbe.entity.ChiTietHoaDon;
import com.example.booshopbe.service.ChiTietHoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chitiethoadon")
public class HoaDonChiTietController {
    @Autowired
    ChiTietHoaDonService chiTietHoaDonService;

    @GetMapping("/find")
    public ApiRespone<List> getList(UUID idHoaDon){
        ApiRespone<List> apiRespone = new ApiRespone<>();
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        apiRespone.setResult(chiTietHoaDonService.getList(idHoaDon));
        return apiRespone;
    }

    @PostMapping("/add")
    public ApiRespone<ChiTietHoaDon> insert(@RequestBody ChiTietHoaDonDTO chiTietHoaDonDTO){
        ApiRespone apiRespone = new ApiRespone<>();
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        apiRespone.setResult(chiTietHoaDonService.insert(chiTietHoaDonDTO));
        return apiRespone;
    }
}
