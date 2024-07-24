package com.example.booshopbe.controller;

import com.example.booshopbe.apirespone.ApiRespone;
import com.example.booshopbe.dto.DoanhThuDTO;
import com.example.booshopbe.service.ThongKeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/hoadontheothang/find")
    public ApiRespone<?> tongHoaDonByMonth(@RequestParam(required = false) int month, @RequestParam(required = false) int year){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(thongKeService.hoaDonHoanThang(month, year));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @GetMapping("/hoadontheonam/{year}")
    public ApiRespone<?> tongHoaDonByYear(@PathVariable("year") int year){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(thongKeService.tongHoaDon(year));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }
    @GetMapping("/hoadontheonam-ht/{year}")
    public ApiRespone<?> tongHoaDonHTByYear(@PathVariable("year") int year){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(thongKeService.hoaDonHTByYear(year));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @GetMapping("/hoadontheothang-ht/find")
    public ApiRespone<?> tongHoaDonHTByMonth(@RequestParam(required = false) int month, @RequestParam(required = false) int year){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(thongKeService.hoaDonHTByMonth(year, month));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @GetMapping("/sanphambanchay")
    public ApiRespone<?> sanPhamBanChay(){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(thongKeService.getBestSellingProducts());
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @GetMapping("/sanphamsaphet")
    public ApiRespone<?> sanPhamSapHet(){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(thongKeService.getNearlyOutOfStockProducts());
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
