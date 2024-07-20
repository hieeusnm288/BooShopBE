package com.example.booshopbe.controller;

import com.example.booshopbe.apirespone.ApiRespone;
import com.example.booshopbe.dto.HoaDonDTO;
import com.example.booshopbe.entity.HoaDon;
import com.example.booshopbe.entity.SanPham;
import com.example.booshopbe.service.HoaDonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/hoadon")
public class HoaDonController {
    @Autowired
    HoaDonService hoaDonService;

    @GetMapping("/all")
    public ApiRespone<List> getListAll() {
        ApiRespone<List> apiRespone = new ApiRespone<>();
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        apiRespone.setResult(hoaDonService.getAll());
        return apiRespone;
    }

    @GetMapping("/find")
    public ApiRespone<List> getListByKhachHang(@RequestParam(required = false) UUID idKhachHang) {
        ApiRespone<List> apiRespone = new ApiRespone<>();
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        apiRespone.setResult(hoaDonService.getByKhachHang(idKhachHang));
        return apiRespone;
    }

    @PostMapping("/add")
    public ApiRespone<HoaDon> insert(@RequestBody HoaDonDTO hoaDonDTO) {
        ApiRespone apiRespone = new ApiRespone<>();
        HoaDon hoaDon = hoaDonService.insert(hoaDonDTO);
        hoaDonDTO.setIdHoaDon(hoaDon.getIdHoaDon());
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        apiRespone.setResult(hoaDonDTO);
        return apiRespone;
    }

    @PutMapping("/{id}")
    public ApiRespone<HoaDon> update(@PathVariable("id") UUID id, @RequestBody HoaDonDTO hoaDonDTO) {
        ApiRespone apiRespone = new ApiRespone<>();
        HoaDon hoaDon = hoaDonService.update(id, hoaDonDTO);
        hoaDonDTO.setIdHoaDon(hoaDon.getIdHoaDon());
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        apiRespone.setResult(hoaDonDTO);
        return apiRespone;
    }

}
