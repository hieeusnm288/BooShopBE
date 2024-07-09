package com.example.booshopbe.controller;

import com.example.booshopbe.apirespone.ApiRespone;
import com.example.booshopbe.entity.KhuyenMai;
import com.example.booshopbe.entity.KichCo;
import com.example.booshopbe.entity.MauSac;
import com.example.booshopbe.entity.NhanVien;
import com.example.booshopbe.service.KhuyenMaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/khuyenmai")
public class KhuyenMaiController {
    @Autowired
    KhuyenMaiService khuyenMaiService;

    @GetMapping("/all")
    public ApiRespone<List> getAll(){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(khuyenMaiService.getAll());
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }
    @PostMapping("/add")
    public ApiRespone<MauSac> insert(@RequestBody KhuyenMai km){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(khuyenMaiService.insert(km));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @GetMapping("/{id}")
    public ApiRespone<KhuyenMai> getDetail(@PathVariable("id") UUID id){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(khuyenMaiService.findById(id));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }

    @PutMapping("/{id}")
    public ApiRespone<KhuyenMai> update(@PathVariable("id") UUID id, @RequestBody KhuyenMai km){
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult(khuyenMaiService.update(id,km));
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }
    @DeleteMapping("/{id}")
    public ApiRespone<?> delete(@PathVariable("id") UUID id){
        khuyenMaiService.deleteById(id);
        ApiRespone apiRespone = new ApiRespone();
        apiRespone.setResult("Xoa Thanh Cong");
        apiRespone.setCode(200);
        apiRespone.setMessage("Success");
        return apiRespone;
    }
}
