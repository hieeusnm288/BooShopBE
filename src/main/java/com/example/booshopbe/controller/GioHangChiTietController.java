package com.example.booshopbe.controller;

import com.example.booshopbe.apirespone.ApiRespone;
import com.example.booshopbe.dto.ChiTietGioHangDTO;
import com.example.booshopbe.entity.GioHang;
import com.example.booshopbe.entity.GioHangChiTiet;
import com.example.booshopbe.service.GioHangChiTietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/giohangchitiet")
public class GioHangChiTietController {

    @Autowired
    GioHangChiTietService gioHangChiTietService;

    @PostMapping("/add")
    public ApiRespone<GioHangChiTiet> muahang(@RequestBody ChiTietGioHangDTO chiTietGioHangDTO){
        ApiRespone apiRespone = new ApiRespone();
//        GioHangChiTiet gioHangChiTiet = ;
//        gioHangChiTiet.setIdGioHangChiTiet(chiTietGioHangDTO.getIdGioHangChiTiet());
        apiRespone.setResult(gioHangChiTietService.addSP(chiTietGioHangDTO));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @DeleteMapping("/{id}")
    public ApiRespone<?> delete(@PathVariable("id") UUID id){
        gioHangChiTietService.deleteSP(id);
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult("Xoa Thanh Cong");
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @GetMapping("/find")
    public ApiRespone<List> getList(@RequestParam(required = false) UUID idGioHang){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(gioHangChiTietService.getListByGioHang(idGioHang));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }
}
