package com.example.booshopbe.controller;

import com.example.booshopbe.apirespone.ApiRespone;
import com.example.booshopbe.dto.ChiTietSanPhamDTO;
import com.example.booshopbe.entity.ChiTietSanPham;
import com.example.booshopbe.service.ChiTietSanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/chitietsanpham")
public class ChiTietSanPhamController {

    @Autowired
    ChiTietSanPhamService chiTietSanPhamService;

    @GetMapping("/search")
    public ApiRespone<List> getChiSanPhamBySanPham(@RequestParam(required = false) UUID idSanPham){
        ApiRespone apiRespone = new ApiRespone();

        apiRespone.setResult(chiTietSanPhamService.getChiSanPhamBySanPhamId(idSanPham));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @PostMapping("/add")
    public ApiRespone<ChiTietSanPham> insert(@RequestBody ChiTietSanPhamDTO chiTietSanPhamDTO){
        ApiRespone apiRespone = new ApiRespone();
        System.out.println(chiTietSanPhamDTO.getIdSanPham());
        ChiTietSanPham chiTietSanPham = chiTietSanPhamService.insert(chiTietSanPhamDTO);
        chiTietSanPhamDTO.setIdChiTietSanPham(chiTietSanPham.getIdChiTietSanPham());
        apiRespone.setResult(chiTietSanPham);
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }
}
