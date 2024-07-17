package com.example.booshopbe.controller;

import com.example.booshopbe.apirespone.ApiRespone;
import com.example.booshopbe.dto.SanPhamDTO;
import com.example.booshopbe.entity.SanPham;
import com.example.booshopbe.responsitory.ChiTietSanPhamReposotory;
import com.example.booshopbe.service.SanPhamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/sanpham")
public class SanPhamController {
    @Autowired
    SanPhamService sanPhamService;

    @Autowired
    ChiTietSanPhamReposotory chiTietSanPhamReposotory;

    @GetMapping("/all")
    public ApiRespone<List> getAll(){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(sanPhamService.getAll());
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @GetMapping("/search")
    public ApiRespone<List> getAllByThuongHieu(@RequestParam(required = false) String name, @RequestParam(required = false) Integer trangthai, @RequestParam(required = true) String idThuongHieu){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(sanPhamService.getByTrangThai(name,trangthai,idThuongHieu));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @GetMapping("/{id}")
    public ApiRespone<SanPham> getById(@PathVariable("id") UUID id){
        System.out.println("12: "+id);
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(sanPhamService.getById(id));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @PostMapping("/add")
    public ApiRespone<SanPham> insert(@RequestBody SanPhamDTO sanPhamDTO){
        ApiRespone apiRespone = new ApiRespone();
        SanPham sanPham = sanPhamService.insert(sanPhamDTO);
        sanPhamDTO.setIdSanPham(sanPham.getIdSanPham());
        apiRespone.setResult(sanPhamDTO);
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

}
