package com.example.booshopbe.controller;

import com.example.booshopbe.apirespone.ApiRespone;
import com.example.booshopbe.dto.DoanhThuDTO;
import com.example.booshopbe.service.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/thongke")
public class ThongKeController {
    @Autowired
    ThongKeService thongKeService;

    @GetMapping("/doanh-thu")
    public ApiRespone<?> getMonthlyRevenue() {
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(thongKeService.getRevenueStatisticsForTrangThaiHoaDon());
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @GetMapping("/tonghoadon")
    public ApiRespone<?> tongHoaDon(){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(thongKeService.tongHoaDon());
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @GetMapping("/tonghoadon-ht")
    public ApiRespone<?> tongHoaDonHT(){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(thongKeService.hoaDonHoanThanh());
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @GetMapping("/tongkhachhang")
    public ApiRespone<?> tongKhachHang(){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(thongKeService.tongKhachHang());
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }
}
